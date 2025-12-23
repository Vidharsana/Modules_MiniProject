package com.mph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mph.dao.PGRepository;
import com.mph.dto.OwnerDTO;
import com.mph.dto.PGDTO;
import com.mph.model.Owner;
import com.mph.model.PG;

@Service
public class PGService {

    @Autowired
    private PGRepository pgRepository;

    // 1. by city
    public List<PGDTO> getAccommodationsByCity(long cityId) {
        List<PG> pgList = pgRepository.findByCityCityId(cityId);
        List<PGDTO> dtoList = new ArrayList<>();
        for (PG pg : pgList) {
            dtoList.add(toDto(pg));
        }
        return dtoList;
    }

    // 2. by locality
    public List<PGDTO> getAccommodationsByLocality(String locality) {
        List<PG> pgList = pgRepository.findByLocality(locality);
        List<PGDTO> dtoList = new ArrayList<>();
        for (PG pg : pgList) {
            dtoList.add(toDto(pg));
        }
        return dtoList;
    }

    // 3. details by id (also increments popularity)
    public PGDTO getAccommodationById(long id) {
        PG pg = pgRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("PG not found with id: " + id));
        pg.setPopularityCount(pg.getPopularityCount() + 1);
        pgRepository.save(pg);
        return toDto(pg);
    }

    // 4. owner details by PG id
    public OwnerDTO getOwnerByPGId(long pgId) {
        PG pg = pgRepository.findById(pgId)
                            .orElseThrow(() -> new RuntimeException("PG not found with id: " + pgId));
        Owner owner = pg.getOwner();
        if (owner == null) throw new RuntimeException("Owner not linked to PG id: " + pgId);
        return new OwnerDTO(owner.getOwnerId(), owner.getName(), owner.getAge(), owner.getContactNo(), owner.getEmailId());
    }

    private PGDTO toDto(PG pg) {
        return new PGDTO(
            pg.getPgId(),
            pg.getName(),
            pg.getArea(),
            pg.getNumberOfRooms(),
            pg.getAvailableRooms(),
            pg.getPopularityCount(),
            pg.getLocality(),
            pg.getRentAmount(),
            pg.isAvailable(),
            pg.getOwner() != null ? pg.getOwner().getOwnerId() : null,
            pg.getCity() != null ? pg.getCity().getCityId() : null
        );
    }
}
