package com.mph.controller;

import com.mph.dto.OwnerDTO;
import com.mph.dto.PGDTO;
import com.mph.model.Owner;
import com.mph.model.PG;
import com.mph.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Owner API")
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    // ✅ Add Owner (new endpoint)
    @PostMapping("/add")
    @Operation(summary = "Register a new owner")
    public ResponseEntity<Owner> addOwner(@RequestBody OwnerDTO ownerdto) {
        Owner newOwner = ownerService.addOwner(ownerdto);
        return ResponseEntity.ok(newOwner);
    }

    // ✅ Add PG place (existing endpoint)
    @PostMapping("/places/add")
    @Operation(summary = "Add a new PG place")
    public ResponseEntity<PG> addPG(@RequestBody PGDTO pgdto) {
        PG newpg = ownerService.addPG(pgdto.getOwnerId(), pgdto);
        return ResponseEntity.ok(newpg);
    }

    // Retrieve all PG places added by the owner
    @GetMapping("/places")
    @Operation
    public ResponseEntity<List<PG>> getPGsByOwner(@RequestParam Long ownerId) {
        return ResponseEntity.ok(ownerService.getPGsByOwner(ownerId));
    }

    // Change availability status using pgdto.isAvailable()
    @PatchMapping("/places/{id}")
    @Operation
    public ResponseEntity<PG> setAvailability(@PathVariable Long id, @RequestBody PGDTO pgdto) {
        PG updated = ownerService.setAvailability(id, pgdto);
        return ResponseEntity.ok(updated);
    }

    // Edit PG details
    @PutMapping("/places/edit")
    @Operation
    public ResponseEntity<PG> editPGDetails(@RequestBody PGDTO pgdto) {
        PG updated = ownerService.editPGDetails(pgdto.getOwnerId(), pgdto);
        return ResponseEntity.ok(updated);
    }

    // Delete PG
    @DeleteMapping("/places/delete/{pgId}")
    @Operation
    public ResponseEntity<String> deletePG(@PathVariable Long pgId) {
        ownerService.deletePG(pgId);
        return ResponseEntity.ok("PG deleted successfully");
    }
}
