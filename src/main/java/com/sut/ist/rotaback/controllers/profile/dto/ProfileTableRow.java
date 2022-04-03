package com.sut.ist.rotaback.controllers.profile.dto;

public class ProfileTableRow {
    private int day;
    private int month;
    private int year;
    private int dangerMomentProbability;
    private String aftermath;
    private int penalty;

    public ProfileTableRow(final int day,
                           final int month,
                           final int year,
                           final int dangerMomentProbability,
                           final boolean aftermath,
                           final int penalty) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dangerMomentProbability = dangerMomentProbability;
        this.aftermath = Aftermath.CRASH.fromBoolean(aftermath);
        this.penalty = penalty;
    }

    public void setDay(final int day) {
        this.day = day;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public void setDangerMomentProbability(final int dangerMomentProbability) {
        this.dangerMomentProbability = dangerMomentProbability;
    }

    public void setAftermath(final String aftermath) {
        this.aftermath = aftermath;
    }

    public void setPenalty(final int penalty) {
        this.penalty = penalty;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getDangerMomentProbability() {
        return dangerMomentProbability;
    }

    public String getAftermath() {
        return aftermath;
    }

    public int getPenalty() {
        return penalty;
    }
}
