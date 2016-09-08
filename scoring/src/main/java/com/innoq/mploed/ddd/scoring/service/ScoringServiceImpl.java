package com.innoq.mploed.ddd.scoring.service;

import com.innoq.mploed.ddd.scoring.shared.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScoringServiceImpl implements ScoringService {

    private static final Logger log = LoggerFactory.getLogger(ScoringServiceImpl.class);

    private RestTemplate restTemplate;

    @Autowired
    public ScoringServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ScoringResult performScoring(ScoringInput scoringInput) {
        log.info("performing scoring");
        ScoringResult result = new ScoringResult();
        int points = 0;

        Map<String, String> requestVariables = new HashMap<String, String>();
        requestVariables.put("firstName", scoringInput.getFirstName());
        requestVariables.put("lastName", scoringInput.getLastName());
        requestVariables.put("postCode", scoringInput.getPostCode());
        requestVariables.put("street", scoringInput.getStreet());
        AgencyResult agencyResult = restTemplate.getForObject("http://localhost:9092/personRating", AgencyResult.class, requestVariables);
        result.setAgencyResult(agencyResult);
        if(scoringInput.getIncome() - scoringInput.getSpendings() > scoringInput.getMonthlyPayment()) {
            points += 50;

            if(scoringInput.getReason() != null && scoringInput.getReason().toUpperCase().contains("PUG")) {
                points += 100;
            } else {
                points -= 20;
            }
        } else {
            points -= 100;
        }


        result.setScoringPoints(points);
        if(points < 0) {
            result.setScoringColor(ScoringColor.RED);
        } else if (points > 100) {
            result.setScoringColor(ScoringColor.GREEN);
        } else {
            result.setScoringColor(ScoringColor.YELLOW);
        }

        log.info("result: " + result.getScoringPoints() + " - " + result.getScoringColor());
        return result;
    }
}
