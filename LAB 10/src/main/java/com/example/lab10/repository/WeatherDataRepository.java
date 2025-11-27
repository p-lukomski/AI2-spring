package com.example.lab10.repository;

import com.example.lab10.model.Location;
import com.example.lab10.model.WeatherData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(path = "weather")
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    Page<WeatherData> findByObservationTimeGreaterThanEqualAndLocation(LocalDateTime observationTime, Location location, Pageable pageable);
}
