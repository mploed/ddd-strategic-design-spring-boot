package com.innoq.mploed.ddd.creditAgency.domain;

import java.util.HashSet;
import java.util.Set;

public class Rating {
    private long points;

    private String color;

    private Set<String> messages = new HashSet<String>();

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public void setMessages(Set<String> messages) {
        this.messages = messages;
    }
}
