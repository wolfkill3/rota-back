package com.sut.ist.rotaback.services.analyze;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRow;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AnalyzeService {
    private static final String BASE_URL = "http://127.0.0.1:5000/rest/analyze";
    private final ObjectMapper mapper = new ObjectMapper();

    public ProfileTableRow[] getTableRows(int count) {
        List<ProfileTableRow> rows = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            rows.add(getTableRow());
        }

        return rows.toArray(new ProfileTableRow[0]);
    }


    private ProfileTableRow getTableRow() {
        var restTemplate = new RestTemplate();
        var rowResponseEntity = restTemplate.getForEntity(BASE_URL, ProfileTableRow.class);
        return rowResponseEntity.getBody();
    }
}
