package com.ethicaltrader.remediation.controller;

import com.ethicaltrader.remediation.model.RemediationAction;
import com.ethicaltrader.remediation.service.RemediationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/remediation/actions")
public class RemediationController {
    @Autowired
    private RemediationService remediationService;

    @GetMapping
    public List<RemediationAction> getAllActions() {
        return remediationService.getAllActions();
    }

    @PostMapping
    public RemediationAction addAction(@RequestBody RemediationAction action) {
        return remediationService.addAction(action);
    }

    @GetMapping("/{id}")
    public Optional<RemediationAction> getActionById(@PathVariable Long id) {
        return remediationService.getActionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable Long id) {
        remediationService.deleteAction(id);
    }
}
