package com.ethicaltrader.compliance.controller;

import com.ethicaltrader.compliance.model.ComplianceRule;
import com.ethicaltrader.compliance.service.ComplianceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compliance/rules")
public class ComplianceRuleController {
    @Autowired
    private ComplianceRuleService ruleService;

    @GetMapping
    public List<ComplianceRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @PostMapping
    public ComplianceRule addRule(@RequestBody ComplianceRule rule) {
        return ruleService.addRule(rule);
    }

    @GetMapping("/{id}")
    public Optional<ComplianceRule> getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
    }
}
