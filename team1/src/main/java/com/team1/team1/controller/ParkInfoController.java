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
    List<ParkInfo> parks = new ArrayList<>();
    @GetMapping("/parkInfo")
    public String showParkInfo(Model model) {
        List<OpeningHour> openingHours = new ArrayList<>();
        openingHours.add(new OpeningHour("Monday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Tuesday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Wednesday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Thursday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Friday", "9:00 AM - 6:00 PM"));
        openingHours.add(new OpeningHour("Saturday", "10:00 AM - 5:00 PM"));
        openingHours.add(new OpeningHour("Sunday", "Closed"));

        ParkInfo park = new ParkInfo(1,"Central Park", "Sport park", 1.5, true, true, true, true, true, true, true, 4.5, openingHours,"/img/park1.jpg");
        ParkInfo park1 = new ParkInfo(2,"Central Park", "Sport park", 1.5, true, true, true, true, true, true, true, 4.5, openingHours,"/img/park1.jpg");
        model.addAttribute("park", park);
        model.addAttribute("park1", park1);
        return "ParkInfo";
    }
    @GetMapping("/showPark/{name}")
    public String showParkByName(@PathVariable String name, Model model) {

        ParkInfo foundPark = new ParkInfo();

        for (ParkInfo park : parks) {

            if (park.getName().equals(name)) {
                foundPark = park;
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
