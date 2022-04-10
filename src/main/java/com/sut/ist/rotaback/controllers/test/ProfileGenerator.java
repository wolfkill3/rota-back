package com.sut.ist.rotaback.controllers.test;

import java.util.*;

import com.sut.ist.rotaback.controllers.profile.dto.Aftermath;
import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRowDTO;

public class ProfileGenerator {
    public static ProfileTableRowDTO[] generateProfiles(int count) {
        List<ProfileTableRowDTO> rows = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rows.add(
                new ProfileTableRowDTO(
                    (int) (Math.random() * 30),
                    (int) (Math.random() * 12),
                    2022,
                    (float) ( 90 + (Math.random() * 10)),
                    Aftermath.CRASH.fromBoolean(Math.random() < 0.5),
                    (int) (Math.random() * 100)
                )
            );
        }
        return rows.toArray(new ProfileTableRowDTO[0]);
    }
}
