package com.team1.team1.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String username;
    private String parkName;
    private Integer rating;
    private String comment;
    private Date createTime;
}
