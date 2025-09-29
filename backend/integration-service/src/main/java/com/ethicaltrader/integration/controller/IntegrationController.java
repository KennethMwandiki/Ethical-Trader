package com.ethicaltrader.integration.controller;

import com.ethicaltrader.integration.model.IntegrationConfig;
import com.ethicaltrader.integration.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/integration/configs")
public class IntegrationController {
    @Autowired
    private IntegrationService integrationService;

    @GetMapping
    public List<IntegrationConfig> getAllConfigs() {
        return integrationService.getAllConfigs();
    }

    @PostMapping
    public IntegrationConfig addConfig(@RequestBody IntegrationConfig config) {
        return integrationService.addConfig(config);
    }

    @GetMapping("/{id}")
    public Optional<IntegrationConfig> getConfigById(@PathVariable Long id) {
        return integrationService.getConfigById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConfig(@PathVariable Long id) {
        integrationService.deleteConfig(id);
    }
}
