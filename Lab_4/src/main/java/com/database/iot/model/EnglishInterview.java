package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class EnglishInterview {
    private Integer id;
    private String level_of_technical;
    private String level_of_speaking;
    private String general_level;

    public EnglishInterview(String level_of_technical, String level_of_speaking, String general_level) {
        this(null, level_of_technical, level_of_speaking, general_level);
    }
}
