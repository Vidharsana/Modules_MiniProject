package com.mph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mph.dao.PGRepository;
import com.mph.dao.TenantRepository;
import com.mph.model.PG;
import com.mph.model.Tenant;

@Service
public class TenantService {
	@Autowired
    private PGRepository pgRepository;

    @Autowired
    private TenantRepository tenantRepository;
    
    public String bookPG(Long pgId, Tenant tenant) {
        PG pg = pgRepository.findById(pgId)
                            .orElseThrow(() -> new RuntimeException("PG not found"));

        if (!pg.isAvailable() || pg.getAvailableRooms() <= 0) {
            return "PG is not available for booking.";
        }

        tenant.setPg(pg);
        tenantRepository.save(tenant);

        pg.setAvailableRooms(pg.getAvailableRooms() - 1);
        if (pg.getAvailableRooms() == 0) {
            pg.setAvailable(false);
        }
        pgRepository.save(pg);

        return "Booking successful for " + tenant.getName();
    }
    
}
