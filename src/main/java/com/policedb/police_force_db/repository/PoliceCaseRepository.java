package com.policedb.police_force_db.repository;

import com.policedb.police_force_db.model.PoliceCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceCaseRepository extends JpaRepository<PoliceCase, Long> {
}
