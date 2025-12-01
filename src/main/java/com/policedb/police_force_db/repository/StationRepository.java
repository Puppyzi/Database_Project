package com.policedb.police_force_db.repository;

import com.policedb.police_force_db.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
