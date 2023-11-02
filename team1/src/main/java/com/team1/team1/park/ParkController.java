package com.team1.team1.park;

import com.team1.team1.hackathon.ParkFilterController;
import com.team1.team1.hackathon.ParkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParkController {
    private static final Logger log = LoggerFactory.getLogger(ParkFilterController.class);

    // In practice, this should be the logic for getting park data from a database or other data source
    private List<Park> parks = List.of(
            new Park("Park1", "park1.jpg", "city"),
            new Park("Park2", "park2.jpg", "nature")
            // more park data
    );

    // In practice, this should be the logic for getting park data from a database or other data source
    private List<Park> slideImg = List.of(
            new Park("Park1", "park1.jpg", "city"),
            new Park("Ad1", "ad1.jpg", "Ad"),
            new Park("Park2", "park2.jpg", "nature"),
            new Park("Ad2", "ad4.jpg", "Ad")
            // 更多公园数据
    );

//    @GetMapping("/parks")
    public String showParks(
            @RequestParam(required = false) String searchText,
            @RequestParam(required = false) String parkType,
            Model model
    ) {

        List<Park> filteredParks = filterParks(searchText, parkType);
        model.addAttribute("parks", filteredParks);
        model.addAttribute("slideImgs", slideImg);
        return "park-recommendation";
    }

    private List<Park> filterParks(String searchText, String parkType) {
        // In practice, park data is filtered according to search criteria
        // Returns a list of eligible parks
        if (searchText != null || parkType != null) {
            if (!searchText.isBlank() || !parkType.isBlank()) {
                List<Park> parks = new ArrayList<>();
                if (!searchText.isBlank()) {
                    this.parks.forEach(element -> {
                        if (element.getName().equalsIgnoreCase(searchText)) {
                            parks.add(element);
                        }
                    });
                } else if (!parkType.isBlank()) {
                    this.parks.forEach(element -> {
                        if (element.getType().equals(parkType)) {
                            parks.add(element);
                        }
                    });
                }
                return parks;
            }else {
                return this.parks;
            }
        } else {
            return this.parks;
        }

    }
    @Autowired
    private ParkService parkService;

    @RequestMapping("/parks")
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
        List<com.team1.team1.hackathon.Park> allParks = parkService.getAllParks();
        log.info("Number of parks before filtering: {}", allParks.size());
        // Filter the parks based on the search and other criteria
        List<com.team1.team1.hackathon.Park> filteredParks = allParks.stream()
                .filter(park -> parkType == null || parkType.isEmpty() || parkType.stream().anyMatch(type -> type.equalsIgnoreCase(park.getType())))
                .filter(park -> distance == null || park.getDistance() <= distance)
                .filter(park -> amenities == null || amenities.isEmpty() || amenities.stream().allMatch(amenity -> park.getAmenities().stream().anyMatch(parkAmenity -> parkAmenity.equalsIgnoreCase(amenity))))
                .filter(park -> accessibility == null || accessibility.isEmpty() || accessibility.stream().allMatch(access -> park.getAccessibility().stream().anyMatch(parkAccess -> parkAccess.equalsIgnoreCase(access))))
                .collect(Collectors.toList());

        log.info("Number of parks after filtering: {}", filteredParks.size());
        model.addAttribute("parks", filteredParks);
        model.addAttribute("slideImgs", slideImg);
        return "park-recommendation"; // Assuming "filter" is the name of the template
    }

}

