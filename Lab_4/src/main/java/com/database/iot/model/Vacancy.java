package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Vacancy {
    private Integer id;
    private String job_desciption;
    private String project_name;

    public Vacancy(String job_desciption, String project_name) {
        this(null, job_desciption, project_name);
    }
}
