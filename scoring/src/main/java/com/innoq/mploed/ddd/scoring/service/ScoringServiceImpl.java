package com.innoq.mploed.ddd.scoring.service;

import com.innoq.mploed.ddd.scoring.shared.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScoringServiceImpl implements ScoringService {

    private static final Logger log = LoggerFactory.getLogger(ScoringServiceImpl.class);

    @Value("${creditAgencyServer}")
    private String creditAgencyServer;

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

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(creditAgencyServer + "personRating")
                .queryParam("firstName", scoringInput.getFirstName())
                .queryParam("lastName", scoringInput.getLastName())
                .queryParam("postCode", scoringInput.getPostCode())
                .queryParam("street", scoringInput.getStreet());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<AgencyResult> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                AgencyResult.class);


        AgencyResult agencyResult = response.getBody();
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
