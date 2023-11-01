package com.team1.team1.park;

import lombok.Data;

@Data
public class Park {
    private String name;
    private String image;
    private String type;

    public Park(String name, String image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }
}
