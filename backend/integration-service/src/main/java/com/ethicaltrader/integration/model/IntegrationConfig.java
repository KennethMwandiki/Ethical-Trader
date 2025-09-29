package com.ethicaltrader.integration.model;

import jakarta.persistence.*;

@Entity
public class IntegrationConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String apiUrl;
    private String apiKey;
    private String tenantNamespace;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getApiUrl() { return apiUrl; }
    public void setApiUrl(String apiUrl) { this.apiUrl = apiUrl; }
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public String getTenantNamespace() { return tenantNamespace; }
    public void setTenantNamespace(String tenantNamespace) { this.tenantNamespace = tenantNamespace; }
}
