package com.develhope.advanced3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT FLIGHT DESCRIPTION", nativeQuery = true)
    List <String> retrieveAllFLights();
}
