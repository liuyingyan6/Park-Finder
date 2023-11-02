package com.team1.team1.model;

import java.util.List;

public class ParkInfo {
    private Integer id;

    public  ParkInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String type;
    private double distance;
    private boolean hasCoffee;
    private boolean hasToilet;
    private boolean hasExerciseEquipment;
    private boolean hasChildrenPlayground;
    private boolean wheelchairAccessible;
    private boolean hasParking;
    private boolean petFriendly;
    private double rating;
    private List<OpeningHour> openingHours;
    private String imagePath;



    public boolean isPetFriendly() {
        return petFriendly;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ParkInfo(Integer id,String name, String type, double distance, boolean hasCoffee, boolean hasToilet,
                    boolean hasExerciseEquipment, boolean hasChildrenPlayground, boolean wheelchairAccessible,
                    boolean hasParking, boolean petFriendly, double rating, List<OpeningHour> openingHours, String imagePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.distance = distance;
        this.hasCoffee = hasCoffee;
        this.hasToilet = hasToilet;
        this.hasExerciseEquipment = hasExerciseEquipment;
        this.hasChildrenPlayground = hasChildrenPlayground;
        this.wheelchairAccessible = wheelchairAccessible;
        this.hasParking = hasParking;
        this.petFriendly = petFriendly;
        this.rating = rating;
        this.openingHours = openingHours;
        this.imagePath = imagePath;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isHasCoffee() {
        return hasCoffee;
    }

    public void setHasCoffee(boolean hasCoffee) {
        this.hasCoffee = hasCoffee;
    }

    public boolean isHasToilet() {
        return hasToilet;
    }

    public void setHasToilet(boolean hasToilet) {
        this.hasToilet = hasToilet;
    }

    public boolean isHasExerciseEquipment() {
        return hasExerciseEquipment;
    }

    public void setHasExerciseEquipment(boolean hasExerciseEquipment) {
        this.hasExerciseEquipment = hasExerciseEquipment;
    }

    public boolean isHasChildrenPlayground() {
        return hasChildrenPlayground;
    }

    public void setHasChildrenPlayground(boolean hasChildrenPlayground) {
        this.hasChildrenPlayground = hasChildrenPlayground;
    }


    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean petFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<OpeningHour> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<OpeningHour> openingHours) {
        this.openingHours = openingHours;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

}
