package com.sut.ist.rotaback.services.analyze;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRowDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AnalyzeService {
    private static final String BASE_URL = "http://127.0.0.1:5000/rest/analyze";
    private final RestTemplate restTemplate = new RestTemplate();

    public ProfileTableRowDTO[] getTableRows(int count) {
        List<ProfileTableRowDTO> rows = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            rows.add(getTableRow());
        }

        rows = rows.stream().sorted().collect(Collectors.toList());
        return rows.toArray(new ProfileTableRowDTO[0]);
    }


    private ProfileTableRowDTO getTableRow() {
        var rowResponseEntity = restTemplate.getForEntity(BASE_URL, ProfileTableRowDTO.class);
        return rowResponseEntity.getBody();
    }
}
