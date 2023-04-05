package com.cherry.assignment.jpa;

import com.cherry.assignment.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    Log findByUid(String uid);

    List<Log> findAllByActive(boolean active);
}
