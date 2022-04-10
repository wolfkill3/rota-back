package com.sut.ist.rotaback.controllers.profile.dto;

import java.util.*;

public class ProfileTableRowDTO implements Comparable<ProfileTableRowDTO> {
    private int day;
    private int month;
    private int year;
    private float dangerMomentProbability;
    private String aftermath;
    private int penalty;

    public ProfileTableRowDTO() {
    }

    public ProfileTableRowDTO(final int day, final int month, final int year, final float dangerMomentProbability, final String aftermath,
                              final int penalty) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dangerMomentProbability = dangerMomentProbability;
        this.aftermath = aftermath;
        this.penalty = penalty;
    }

    public int getDay() {
        return day;
    }

    public void setDay(final int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public float getDangerMomentProbability() {
        return dangerMomentProbability;
    }

    public void setDangerMomentProbability(final float dangerMomentProbability) {
        this.dangerMomentProbability = dangerMomentProbability;
    }

    public String getAftermath() {
        return aftermath;
    }

    public void setAftermath(final String aftermath) {
        this.aftermath = aftermath;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(final int penalty) {
        this.penalty = penalty;
    }

    @Override
    public int compareTo(final ProfileTableRowDTO row) {
        return new GregorianCalendar(row.year, row.month - 1, row.day).compareTo(new GregorianCalendar(year, month-1, day));
    }
}