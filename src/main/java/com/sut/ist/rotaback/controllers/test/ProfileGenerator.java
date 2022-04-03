package com.sut.ist.rotaback.controllers.test;

import java.util.*;

import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRow;

public class ProfileGenerator {
    public static ProfileTableRow[] generateProfiles(int count) {
        List<ProfileTableRow> rows = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rows.add(
                new ProfileTableRow(
                    (int) (Math.random() * 30),
                    (int) (Math.random() * 12),
                    2022,
                    (int) (90 + (Math.random() * 10)),
                    Math.random() < 0.5,
                    (int) (Math.random() * 100)
                )
            );
        }
        return rows.toArray(new ProfileTableRow[0]);
    }
}
