package com.example.lab10.repository;

import com.example.lab10.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    Page<Location> findByCountryCode(String countryCode, Pageable pageable);
    Optional<Location> findByCity(String city);
}
