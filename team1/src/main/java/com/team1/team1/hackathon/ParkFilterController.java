package com.team1.team1.hackathon;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParkFilterController {
    private static final Logger log = LoggerFactory.getLogger(ParkFilterController.class);
    @Autowired
    private ParkService parkService;

    @RequestMapping("/filter")
    public String viewParks(Model model,
                            @RequestParam(required = false) List<String> parkType,
                            @RequestParam(required = false) Integer distance,
                            @RequestParam(required = false) List<String> amenities,
                            @RequestParam(required = false) List<String> accessibility) {

        log.info("Received park types: {}", parkType);
        log.info("Received distance: {}", distance);
        log.info("Received amenities: {}", amenities);
        log.info("Received accessibility: {}", accessibility);

        // Get all parks from the ParkService
        List<Park> allParks = parkService.getAllParks();
        log.info("Number of parks before filtering: {}", allParks.size());
        // Filter the parks based on the search and other criteria
        List<Park> filteredParks = allParks.stream()
                .filter(park -> parkType == null || parkType.isEmpty() || parkType.stream().anyMatch(type -> type.equalsIgnoreCase(park.getType())))
                .filter(park -> distance == null || park.getDistance() <= distance)
                .filter(park -> amenities == null || amenities.isEmpty() || amenities.stream().allMatch(amenity -> park.getAmenities().stream().anyMatch(parkAmenity -> parkAmenity.equalsIgnoreCase(amenity))))
                .filter(park -> accessibility == null || accessibility.isEmpty() || accessibility.stream().allMatch(access -> park.getAccessibility().stream().anyMatch(parkAccess -> parkAccess.equalsIgnoreCase(access))))
                .collect(Collectors.toList());

        log.info("Number of parks after filtering: {}", filteredParks.size());
        model.addAttribute("parks", filteredParks);
        return "filter"; // Assuming "filter" is the name of the template
    }

}


