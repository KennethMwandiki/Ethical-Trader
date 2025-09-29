package com.ethicaltrader.monitoring.service;

import com.ethicaltrader.monitoring.model.Alert;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlertService {
    private final List<Alert> alerts = new ArrayList<>();

    public List<Alert> getAllAlerts() {
        return alerts;
    }

    public Alert addAlert(Alert alert) {
        alerts.add(alert);
        return alert;
    }

    public Optional<Alert> getAlertById(Long id) {
        return alerts.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public void deleteAlert(Long id) {
        alerts.removeIf(a -> a.getId().equals(id));
    }
}
