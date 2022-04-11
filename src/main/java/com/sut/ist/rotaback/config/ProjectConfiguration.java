package com.sut.ist.rotaback.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "project")
public class ProjectConfiguration {
    private String analyzeUrl;

    public String getAnalyzeUrl() {
        return analyzeUrl;
    }

    public void setAnalyzeUrl(final String analyzeUrl) {
        if (this.analyzeUrl == null) {
            this.analyzeUrl = analyzeUrl;
        } else {
            throw new RuntimeException("Try to change configuration properties");
        }
    }
}
