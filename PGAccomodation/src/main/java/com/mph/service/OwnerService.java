package com.mph.service;

import com.mph.dao.OwnerRepository;
import com.mph.dao.PGRepository;
import com.mph.dto.OwnerDTO;
import com.mph.dto.PGDTO;
import com.mph.model.Owner;
import com.mph.model.PG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepo;

    @Autowired
    private PGRepository pgRepo;

    // ✅ Add Owner
    public Owner addOwner(OwnerDTO ownerdto) {
        if (ownerdto.getAge() < 18) {
            throw new RuntimeException("Owner must be at least 18 years old.");
        }
        Owner owner = new Owner();
        owner.setName(ownerdto.getName());
        owner.setAge(ownerdto.getAge());
        owner.setContactNo(ownerdto.getContactNo());
        owner.setEmailId(ownerdto.getEmailId());
        return ownerRepo.save(owner);
    }

    // ✅ Add PG
    public PG addPG(Long ownerId, PGDTO pgdto) {
        Owner owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        PG pg = new PG();
        pg.setName(pgdto.getName());
        pg.setArea(pgdto.getArea());
        pg.setNumberOfRooms(pgdto.getNumberOfRooms());
        pg.setAvailableRooms(pgdto.getAvailableRooms());
        pg.setPopularityCount(pgdto.getPopularityCount());
        pg.setLocality(pgdto.getLocality());
        pg.setRentAmount(pgdto.getRentAmount());
        pg.setAvailable(pgdto.isAvailable());
        pg.setOwner(owner);

        return pgRepo.save(pg);
    }

    // Retrieve PGs by owner
    public List<PG> getPGsByOwner(Long ownerId) {
        Owner owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return owner.getPgList();
    }

    // Set availability using pgdto.isAvailable()
    public PG setAvailability(Long pgId, PGDTO pgdto) {
        PG pg = pgRepo.findById(pgId)
                .orElseThrow(() -> new RuntimeException("PG not found"));
        pg.setAvailable(pgdto.isAvailable());
        return pgRepo.save(pg);
    }

    // Edit PG details
    public PG editPGDetails(Long ownerId, PGDTO pgdto) {
        PG pg = pgRepo.findById(pgdto.getPgId())
                .orElseThrow(() -> new RuntimeException("PG not found"));

        if (!pg.getOwner().getOwnerId().equals(ownerId)) {
            throw new RuntimeException("Unauthorized: PG does not belong to this owner");
        }

        pg.setName(pgdto.getName());
        pg.setArea(pgdto.getArea());
        pg.setNumberOfRooms(pgdto.getNumberOfRooms());
        pg.setAvailableRooms(pgdto.getAvailableRooms());
        pg.setPopularityCount(pgdto.getPopularityCount());
        pg.setLocality(pgdto.getLocality());
        pg.setRentAmount(pgdto.getRentAmount());
        pg.setAvailable(pgdto.isAvailable());

        return pgRepo.save(pg);
    }

    // Delete PG
    public void deletePG(Long pgId) {
        PG pg = pgRepo.findById(pgId)
                .orElseThrow(() -> new RuntimeException("PG not found"));
        pgRepo.delete(pg);
    }
}
