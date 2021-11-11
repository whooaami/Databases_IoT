package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Coment {
    private Integer id;
    private String rating;
    private String response;

    public Coment(String rating, String response) {
        this(null, rating, response);
    }
}
