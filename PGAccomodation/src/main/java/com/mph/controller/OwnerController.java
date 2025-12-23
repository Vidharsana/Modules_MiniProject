package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mph.dto.PGDTO;
import com.mph.model.PG;
import com.mph.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    // 5. Add a new PG place
    @PostMapping("/places/add")
    public ResponseEntity<PG> addPG(@RequestBody PGDTO pgdto) {
        PG newpg = ownerService.addPG(pgdto);
        return ResponseEntity.ok(newpg);
    }

    // 6. Retrieve all PG places added by the owner
    @GetMapping("/places")
    public ResponseEntity<List<PG>> getPGsByOwner() {
        List<PG> pgList = ownerService.getPGsByOwner();
        return ResponseEntity.ok(pgList);
    }

    // 7. Change the status of PG place (Available or Not Available)
    @PutMapping("/places/{id}")
    public ResponseEntity<PG> changePGAvailability(@PathVariable Long id) {
        PG updated = ownerService.toggleAvailability(id);
        return ResponseEntity.ok(updated);
    }

    // 8. Edit Place details
    @PutMapping("/places/edit")
    public ResponseEntity<PG> editPGDetails(@RequestBody PGDTO pgdto) {
        PG updated = ownerService.editPGDetails(pgdto);
        return ResponseEntity.ok(updated);
    }

    // 9. Delete Place Details
    @DeleteMapping("/places/delete")
    public ResponseEntity<String> deletePG(@RequestParam Long pgId) {
        ownerService.deletePG(pgId);
        return ResponseEntity.ok("PG deleted successfully");
    }
}
