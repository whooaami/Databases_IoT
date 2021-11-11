package com.database.iot.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor

public class CandidateCV {
    private Integer id;
    private String job;
    private String work_experience;
    private String place_of_study;
    private String hobby;
    private String skills;

    public CandidateCV(String job, String work_experience, String place_of_study,
                       String hobby, String skills) {
        this(null, job, work_experience, place_of_study, hobby, skills);
    }
}
