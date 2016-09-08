package com.innoq.mploed.ddd.scoring.shared;

import java.io.Serializable;

public class ScoringResult implements Serializable {
    private ScoringColor scoringColor;
    private int scoringPoints;
    private AgencyResult agencyResult;

    public ScoringColor getScoringColor() {
        return scoringColor;
    }

    public void setScoringColor(ScoringColor scoringColor) {
        this.scoringColor = scoringColor;
    }

    public int getScoringPoints() {
        return scoringPoints;
    }

    public void setScoringPoints(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }

    public AgencyResult getAgencyResult() {
        return agencyResult;
    }

    public void setAgencyResult(AgencyResult agencyResult) {
        this.agencyResult = agencyResult;
    }
}
