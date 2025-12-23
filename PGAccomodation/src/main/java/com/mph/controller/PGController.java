package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mph.dto.PGDTO;
import com.mph.dto.OwnerDTO;
import com.mph.service.PGService;

@RestController
@RequestMapping("/pg")
public class PGController {

    @Autowired
    private PGService pgService;

    // 1. Retrieve available PG places in a specific city
    @GetMapping("/city/{city_id}")
    public ResponseEntity<List<PGDTO>> getPGsByCity(@PathVariable long city_id) {
        List<PGDTO> pgList = pgService.getAccommodationsByCity(city_id);
        return pgList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pgList);
    }

    // 2. List out available PG places in a specific locality
    @GetMapping("/locality/{locality}")
    public ResponseEntity<List<PGDTO>> getPGsByLocality(@PathVariable String locality) {
        List<PGDTO> pgList = pgService.getAccommodationsByLocality(locality);
        return pgList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pgList);
    }

    // 3. Retrieve a specific PG place detail by id
    @GetMapping("/details/{id}")
    public ResponseEntity<PGDTO> getPGDetails(@PathVariable long id) {
        PGDTO pgDto = pgService.getAccommodationById(id);
        return ResponseEntity.ok(pgDto);
    }

    // 4. Retrieve the owner details of a specific PG
    @GetMapping("/owner/{id}")
    public ResponseEntity<OwnerDTO> getOwnerByPGId(@PathVariable long id) {
        OwnerDTO ownerDto = pgService.getOwnerByPGId(id);
        return ResponseEntity.ok(ownerDto);
    }
}
