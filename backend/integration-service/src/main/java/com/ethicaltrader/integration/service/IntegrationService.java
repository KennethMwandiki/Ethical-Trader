package com.ethicaltrader.integration.service;

import com.ethicaltrader.integration.model.IntegrationConfig;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class IntegrationService {
    private final List<IntegrationConfig> configs = new ArrayList<>();

    public List<IntegrationConfig> getAllConfigs() {
        return configs;
    }

    public IntegrationConfig addConfig(IntegrationConfig config) {
        configs.add(config);
        return config;
    }

    public Optional<IntegrationConfig> getConfigById(Long id) {
        return configs.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void deleteConfig(Long id) {
        configs.removeIf(c -> c.getId().equals(id));
    }
}
