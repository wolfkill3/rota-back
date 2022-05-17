package com.sut.ist.rotaback.services;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.ist.rotaback.config.ProjectConfiguration;
import com.sut.ist.rotaback.controllers.profile.dto.ProfileTableRowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class AnalyzeService {
    private static final String PATH = "/rest/analyze";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ProjectConfiguration configuration;

    @Autowired
    public AnalyzeService(final ProjectConfiguration configuration) {
        this.configuration = configuration;
    }

    public ProfileTableRowDTO[] getTableRows(int count) {
        List<ProfileTableRowDTO> rows = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            rows.add(getTableRow());
        }

        rows = rows.stream().sorted().collect(Collectors.toList());
        return rows.toArray(new ProfileTableRowDTO[0]);
    }

    private ProfileTableRowDTO getTableRow() {
        var rowResponseEntity = restTemplate.getForEntity(configuration.getAnalyzeUrl() + PATH, ProfileTableRowDTO.class);
        return rowResponseEntity.getBody();
    }
}
