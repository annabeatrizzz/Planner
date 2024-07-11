package com.rocketseat.planner.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    //METHODS
    List<Participant> findByTripId(UUID tripId);
}