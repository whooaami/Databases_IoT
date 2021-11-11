package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class PotentialCandidate {
    private Integer id;
    private String name;
    private String surname;
    private Integer phone_number;
    private String email;
    private String github;
    private String linkedin;
    private Integer candidate_cv_id;
    private Integer english_interview_id;
    private Integer technical_interview_id;
    private Integer mark_of_interview_id;


    public PotentialCandidate(String name, String surname, Integer phone_number, String email, String github,
                              String linkedin, Integer candidate_cv_id, Integer english_interview_id,
                              Integer technical_interview_id, Integer mark_of_interview_id) {
        this(null, name, surname, phone_number, email, github, linkedin, candidate_cv_id, english_interview_id,
                technical_interview_id, mark_of_interview_id);
    }
}
