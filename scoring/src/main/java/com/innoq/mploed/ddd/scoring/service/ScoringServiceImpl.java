package com.innoq.mploed.ddd.scoring.service;

import com.innoq.mploed.ddd.scoring.shared.ScoringColor;
import com.innoq.mploed.ddd.scoring.shared.ScoringInput;
import com.innoq.mploed.ddd.scoring.shared.ScoringResult;
import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScoringServiceImpl implements ScoringService {

    private static final Logger log = LoggerFactory.getLogger(ScoringServiceImpl.class);

    @Override
    public ScoringResult performScoring(ScoringInput scoringInput) {
        log.info("performing scoring");
        ScoringResult result = new ScoringResult();
        int points = 0;
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
