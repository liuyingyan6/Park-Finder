package com.team1.team1.park;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParkController {
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

    @GetMapping("/parks")
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
}

