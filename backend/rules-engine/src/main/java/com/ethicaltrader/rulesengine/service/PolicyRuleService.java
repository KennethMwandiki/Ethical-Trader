package com.ethicaltrader.rulesengine.service;

import com.ethicaltrader.rulesengine.model.PolicyRule;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PolicyRuleService {
    private final List<PolicyRule> rules = new ArrayList<>();

    public List<PolicyRule> getAllRules() {
        return rules;
    }

    public PolicyRule addRule(PolicyRule rule) {
        rules.add(rule);
        return rule;
    }

    public Optional<PolicyRule> getRuleById(Long id) {
        return rules.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public void deleteRule(Long id) {
        rules.removeIf(r -> r.getId().equals(id));
    }
}
