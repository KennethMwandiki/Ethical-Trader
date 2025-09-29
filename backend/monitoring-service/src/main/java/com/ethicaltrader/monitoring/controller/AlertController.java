package com.ethicaltrader.monitoring.controller;

import com.ethicaltrader.monitoring.model.Alert;
import com.ethicaltrader.monitoring.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monitoring/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @PostMapping
    public Alert addAlert(@RequestBody Alert alert) {
        return alertService.addAlert(alert);
    }

    @GetMapping("/{id}")
    public Optional<Alert> getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
    }
}
