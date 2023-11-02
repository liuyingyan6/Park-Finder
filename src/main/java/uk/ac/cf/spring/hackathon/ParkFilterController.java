package uk.ac.cf.spring.hackathon;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParkFilterController {

    @Autowired
    private ParkService parkService;

    @RequestMapping("/filter") // Mapping for "/filter" endpoint
    public String viewParks(Model model,
                            @RequestParam(required = false) List<String> parkType,
                            @RequestParam(required = false) Integer distance,
                            @RequestParam(required = false) List<String> amenities,
                            @RequestParam(required = false) List<String> accessibility) {

        // Get all parks from the ParkService
        List<Park> allParks = parkService.getAllParks();

        List<Park> filteredParks = allParks.stream()
                .filter(park -> parkType == null || parkType.contains(park.getType()))
                .filter(park -> distance == null || park.getDistance() <= distance)
                .filter(park -> amenities == null || park.getAmenities().containsAll(amenities))
                .filter(park -> accessibility == null || park.getAccessibility().containsAll(accessibility))
                .collect(Collectors.toList());

        model.addAttribute("parks", filteredParks);
        return "filter";
        // Add the filtered parks to the model
    }
    @Service
    public static class ParkService {

        private List<Park> parks = new ArrayList<>(Arrays.asList(  // List of parks with sample data for testing functionality
                new Park("Park A", "Urban Park", 5, Arrays.asList("Cafe", "Toilets"), Arrays.asList("Wheelchair Access"), new ArrayList<>()),
                new Park("Park B", "Sports Park", 10, Arrays.asList("Sports Facilities", "Cafe"), Arrays.asList("Car Park"), new ArrayList<>()),
                new Park("park C", "Dog Park", 15, Arrays.asList("Children's area, cafe"),Arrays.asList("Animals Allowed"), new ArrayList<>())// Add more parks here
        ));

        public List<Park> getAllParks() {  // Retrieve all parks
            return parks;
        }


    }

    public static class Park { // Define a park class for the park information
        private String name;
        private String type;
        private int distance;
        private List<String> amenities;
        private List<String> accessibility;
        private List<String> comments;

        public Park(String name, String type, int distance, List<String> amenities, List<String> accessibility, List<String> comments) {
            this.name = name;
            this.type = type;
            this.distance = distance;
            this.amenities = amenities;
            this.accessibility = accessibility;
            this.comments = comments;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getDistance() {
            return distance;
        }

        public List<String> getAmenities() {
            return amenities;
        }

        public List<String> getAccessibility() {
            return accessibility;
        }
    }
}


