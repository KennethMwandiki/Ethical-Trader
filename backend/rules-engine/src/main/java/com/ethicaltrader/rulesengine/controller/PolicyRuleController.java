package com.ethicaltrader.rulesengine.controller;

import com.ethicaltrader.rulesengine.model.PolicyRule;
import com.ethicaltrader.rulesengine.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules/policies")
public class PolicyRuleController {
    @Autowired
    private PolicyRuleService ruleService;

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @PostMapping
    public PolicyRule addRule(@RequestBody PolicyRule rule) {
        return ruleService.addRule(rule);
    }

    @GetMapping("/{id}")
    public Optional<PolicyRule> getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
    }
}
