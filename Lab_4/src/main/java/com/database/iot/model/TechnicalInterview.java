package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class TechnicalInterview {
    private Integer id;
    private String programming_language;
    private String algorithm;
    private String data_structure;
    private String database;
    private String result_interview;

    public TechnicalInterview(String programming_language, String algorithm, String data_structure, String database,
                              String result_interview) {
        this(null, programming_language, algorithm, data_structure, database, result_interview);
    }
}
