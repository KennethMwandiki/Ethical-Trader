package com.ethicaltrader.compliance.controller;

import com.ethicaltrader.compliance.model.Tenant;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/compliance/tenants")
public class TenantController {
    private final List<Tenant> tenants = new ArrayList<>();

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenants;
    }

    @PostMapping
    public Tenant addTenant(@RequestBody Tenant tenant) {
        tenants.add(tenant);
        return tenant;
    }
}
