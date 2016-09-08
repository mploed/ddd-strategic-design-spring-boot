package com.innoq.mploed.ddd.scoring.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AgencyResult implements Serializable {
    private Set<String> warnings = new HashSet<String>();
    private AgencyColor color;
    private int points;

    public Set<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(Set<String> warnings) {
        this.warnings = warnings;
    }

    public AgencyColor getColor() {
        return color;
    }

    public void setColor(AgencyColor color) {
        this.color = color;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
