package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
    
    @Autowired
    private LocationRepository locationRepository;
    
    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        Location savedLocation = locationRepository.save(location);
        return ResponseEntity.ok(savedLocation);
    }
    
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }
    
    @GetMapping("/recent")
    public ResponseEntity<List<Location>> getRecentLocations() {
        List<Location> locations = locationRepository.findTop10ByOrderByTimestampDesc();
        return ResponseEntity.ok(locations);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
