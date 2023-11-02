package com.team1.team1.review;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Review {
    private String username;
    private String parkName;
    private Integer rating;
    private String context;
    private Date createTime;
}
