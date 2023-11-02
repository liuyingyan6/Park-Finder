package com.team1.team1.hackathon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ParkService {
        private List<Park> parks = new ArrayList<>(Arrays.asList(  // List of parks with sample data for testing functionality
                new Park("ParkA", "Urban Park", 5, Arrays.asList("Cafe", "Toilets"), Arrays.asList("Wheelchair Access"), new ArrayList<>()),
                new Park("ParkB", "Sports Park", 10, Arrays.asList("Sports Facilities", "Cafe"), Arrays.asList("Car Park"), new ArrayList<>()),
                new Park("ParkC", "Dog Park", 15, Arrays.asList("Children's area", "cafe"),Arrays.asList("Animals Allowed"), new ArrayList<>())
        ));

        public List<Park> getAllParks() {  // Retrieve all parks
            return parks;
        }
}
