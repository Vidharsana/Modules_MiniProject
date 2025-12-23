package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mph.dao.CityRepository;
import com.mph.dao.OwnerRepository;
import com.mph.dao.PGRepository;
import com.mph.dto.PGDTO;
import com.mph.model.City;
import com.mph.model.Owner;
import com.mph.model.PG;

@Service
public class OwnerService {

    @Autowired
    private PGRepository pgRepo;

    @Autowired
    private OwnerRepository ownerRepo;

    @Autowired
    private CityRepository cityRepo;

    // 5. Add a new PG place
    public PG addPG(PGDTO pgdto) {
        if (pgdto.getOwnerId() == null) throw new RuntimeException("ownerId is required in PGDTO");
        if (pgdto.getCityId() == null) throw new RuntimeException("cityId is required in PGDTO");

        Owner owner = ownerRepo.findById(pgdto.getOwnerId())
                               .orElseThrow(() -> new RuntimeException("Owner not found"));
        City city = cityRepo.findById(pgdto.getCityId())
                            .orElseThrow(() -> new RuntimeException("City not found"));

        PG pg = new PG();
        pg.setName(pgdto.getName());
        pg.setArea(pgdto.getArea());
        pg.setNumberOfRooms(pgdto.getNumberOfRooms());
        pg.setAvailableRooms(pgdto.getAvailableRooms());
        pg.setPopularityCount(pgdto.getPopularityCount());
        pg.setLocality(pgdto.getLocality());
        pg.setRentAmount(pgdto.getRentAmount());
        pg.setAvailable(pgdto.getAvailableRooms() > 0);
        pg.setOwner(owner);
        pg.setCity(city);

        return pgRepo.save(pg);
    }

    // 6. Retrieve all PG places added by the owner
    public List<PG> getPGsByOwner() {
        // If you want to filter by specific owner, adjust this to a query using ownerId context
        return pgRepo.findAll();
    }

    // 7. Change availability
    public PG toggleAvailability(Long pgId) {
        PG pg = pgRepo.findById(pgId)
                      .orElseThrow(() -> new RuntimeException("PG not found"));
        pg.setAvailable(!pg.isAvailable());
        return pgRepo.save(pg);
    }

    // 8. Edit place details
    public PG editPGDetails(PGDTO pgdto) {
        if (pgdto.getPgId() == null) throw new RuntimeException("pgId is required to edit place");

        PG pg = pgRepo.findById(pgdto.getPgId())
                      .orElseThrow(() -> new RuntimeException("PG not found"));

        // optional: verify owner via pgdto.getOwnerId() if needed
        if (pgdto.getName() != null) pg.setName(pgdto.getName());
        pg.setArea(pgdto.getArea());
        pg.setNumberOfRooms(pgdto.getNumberOfRooms());
        pg.setAvailableRooms(pgdto.getAvailableRooms());
        pg.setPopularityCount(pgdto.getPopularityCount());
        if (pgdto.getLocality() != null) pg.setLocality(pgdto.getLocality());
        pg.setRentAmount(pgdto.getRentAmount());
        pg.setAvailable(pgdto.getAvailableRooms() > 0);

        if (pgdto.getCityId() != null) {
            City city = cityRepo.findById(pgdto.getCityId())
                                .orElseThrow(() -> new RuntimeException("City not found"));
            pg.setCity(city);
        }

        if (pgdto.getOwnerId() != null) {
            Owner owner = ownerRepo.findById(pgdto.getOwnerId())
                                   .orElseThrow(() -> new RuntimeException("Owner not found"));
            pg.setOwner(owner);
        }

        return pgRepo.save(pg);
    }

    // 9. Delete place
    public void deletePG(Long pgId) {
        PG pg = pgRepo.findById(pgId)
                      .orElseThrow(() -> new RuntimeException("PG not found"));
        pgRepo.delete(pg);
    }
}
