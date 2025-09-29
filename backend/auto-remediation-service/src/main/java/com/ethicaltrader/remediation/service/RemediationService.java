package com.ethicaltrader.remediation.service;

import com.ethicaltrader.remediation.model.RemediationAction;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RemediationService {
    private final List<RemediationAction> actions = new ArrayList<>();

    public List<RemediationAction> getAllActions() {
        return actions;
    }

    public RemediationAction addAction(RemediationAction action) {
        actions.add(action);
        return action;
    }

    public Optional<RemediationAction> getActionById(Long id) {
        return actions.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public void deleteAction(Long id) {
        actions.removeIf(a -> a.getId().equals(id));
    }
}
