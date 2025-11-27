package com.example.lab10.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime observationTime;
    private double temperature;
    private double precipitation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public WeatherData() {}
    public WeatherData(LocalDateTime observationTime, double temperature, double precipitation) {
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public long getId() { return id; }
    public LocalDateTime getObservationTime() { return observationTime; }
    public void setObservationTime(LocalDateTime observationTime) { this.observationTime = observationTime; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public double getPrecipitation() { return precipitation; }
    public void setPrecipitation(double precipitation) { this.precipitation = precipitation; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
