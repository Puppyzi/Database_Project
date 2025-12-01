package com.policedb.police_force_db.repository;

import com.policedb.police_force_db.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer, Long> {
}
