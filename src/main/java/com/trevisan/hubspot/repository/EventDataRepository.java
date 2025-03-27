package com.trevisan.hubspot.repository;

import com.trevisan.hubspot.model.EventData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDataRepository extends JpaRepository<EventData, Long> {
}
