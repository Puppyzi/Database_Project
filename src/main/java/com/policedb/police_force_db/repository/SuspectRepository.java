package com.policedb.police_force_db.repository;

import com.policedb.police_force_db.model.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepository extends JpaRepository<Suspect, Long> {
}
