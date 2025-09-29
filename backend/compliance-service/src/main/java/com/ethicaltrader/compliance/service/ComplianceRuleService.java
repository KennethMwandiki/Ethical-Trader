package com.ethicaltrader.compliance.service;

import com.ethicaltrader.compliance.model.ComplianceRule;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ComplianceRuleService {
    private final List<ComplianceRule> rules = new ArrayList<>();

    public List<ComplianceRule> getAllRules() {
        return rules;
    }

    public ComplianceRule addRule(ComplianceRule rule) {
        rules.add(rule);
        return rule;
    }

    public Optional<ComplianceRule> getRuleById(Long id) {
        return rules.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public void deleteRule(Long id) {
        rules.removeIf(r -> r.getId().equals(id));
    }
}
