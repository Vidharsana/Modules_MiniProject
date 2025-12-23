package com.mph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mph.model.Tenant;
import com.mph.service.TenantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Tenant API")
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/{pgId}")
    @Operation(summary = "Book a PG for a tenant")
    public ResponseEntity<String> bookPG(@PathVariable Long pgId, @RequestBody Tenant tenant) {
        try {
            String response = tenantService.bookPG(pgId, tenant);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
