package uk.ac.cf.spring.hackathon;

import java.util.List;

public class Park { // Define a park class for the park information
        private String name;
        private String type;
        private int distance;
        private List<String> amenities;
        private List<String> accessibility;

        public Park(String name, String type, int distance, List<String> amenities, List<String> accessibility, List<String> comments) {
            this.name = name;
            this.type = type;
            this.distance = distance;
            this.amenities = amenities;
            this.accessibility = accessibility;
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
