package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class MarkOfInterview {
    private Integer id;
    private String level;
    private Integer coment_id;

    public MarkOfInterview(String level, Integer coment_id) {
        this(null, level, coment_id);
    }
}

