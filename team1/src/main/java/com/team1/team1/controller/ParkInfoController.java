package com.team1.team1.controller;

import com.team1.team1.model.OpeningHour;
import com.team1.team1.model.ParkInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParkInfoController {
    List<OpeningHour> openingHours = new ArrayList<>();
    List<ParkInfo> parks = new ArrayList<>();

    public ParkInfoController() {

        ParkInfo parkA = new ParkInfo(1, "ParkA", "Urban Park", 5, true, true, true, true, true, true, true, 4.5, openingHours, "/img/park1.jpg");
        parks.add(parkA);

        ParkInfo parkB = new ParkInfo(2, "ParkB", "Sports Park", 10, true, true, true, true, false, true, true, 4.0, openingHours, "/img/park2.jpg");
        parks.add(parkB);

        ParkInfo parkC = new ParkInfo(3, "ParkC", "Dog Park", 3.0, true, true, false, true, true, true, true, 4.0, openingHours, "/img/park3.jpg");
        parks.add(parkC);

    }

    @GetMapping("/parkInfo/{name}")
    public String showParkInfo(Model model) {


        ParkInfo park = new ParkInfo(1,"Central Park", "Sport park", 1.5, true, true, true, true, true, true, true, 4.5, openingHours,"/img/park1.jpg");
        model.addAttribute("park", park);
        return "ParkInfo";
    }
    @GetMapping("/showPark/{name}")
    public String showPark(Model model,@PathVariable String name) {

        ParkInfo foundPark = new ParkInfo();
        List<OpeningHour> openingHours = new ArrayList<>();
        openingHours.add(new OpeningHour("Monday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Tuesday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Wednesday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Thursday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Friday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Saturday", "10:00 AM - 5:00 PM"));
        openingHours.add(new OpeningHour("Sunday", "Closed"));
        for (ParkInfo park : parks) {
            if (park.getName().equals(name)) {
                foundPark = park;
                foundPark.setOpeningHours(openingHours);
                break;
            }
        }
        if (foundPark != null) {
            model.addAttribute("park", foundPark);
            return "ParkInfo";
        } else {
            return "errorPage";
        }
    }

}
