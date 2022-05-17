package com.sut.ist.rotaback.controllers.rating.dto;

public class RatingProfile implements Comparable<RatingProfile> {
    public Integer number;
    public String fullName;
    public String city;
    public Integer score;

    @Override
    public int compareTo(final RatingProfile o) {
        return o.number.compareTo(number);
    }
}
