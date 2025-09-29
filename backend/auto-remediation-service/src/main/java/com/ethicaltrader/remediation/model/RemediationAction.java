package com.ethicaltrader.remediation.model;

import jakarta.persistence.*;

@Entity
public class RemediationAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String violationType;
    private String action;
    private String status;
    private String tenantNamespace;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTenantNamespace() { return tenantNamespace; }
    public void setTenantNamespace(String tenantNamespace) { this.tenantNamespace = tenantNamespace; }
}
