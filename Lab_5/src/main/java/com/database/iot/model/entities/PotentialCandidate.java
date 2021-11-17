package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "potential_candidate")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class PotentialCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private Integer phone_number;
    @Column(name = "email")
    private String email;
    @Column(name = "github")
    private String github;
    @Column(name = "linkedin")
    private String  linkedin;
    @Column(name = "candidate_cv_id")
    private Integer candidate_cv_id;
    @Column(name = "english_interview_id")
    private Integer english_interview_id;
    @Column(name = "technical_interview_id")
    private Integer technical_interview_id;
    @Column(name = "mark_of_interview_id")
    private Integer mark_of_interview_id;

    public PotentialCandidate(Integer id, String name, String surname, Integer phone_number, String email,
                              String github, String linkedin, Integer candidate_cv_id, Integer english_interview_id,
                              Integer technical_interview_id, Integer mark_of_interview_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;
        this.github = github;
        this.linkedin = linkedin;
        this.candidate_cv_id = candidate_cv_id;
        this.english_interview_id = english_interview_id;
        this.technical_interview_id = technical_interview_id;
        this.mark_of_interview_id = mark_of_interview_id;
    }

    @Override
    public String toString() {
        return "PotentialCandidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", github='" + github + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", candidate_cv_id=" + candidate_cv_id +
                ", english_interview_id=" + english_interview_id +
                ", technical_interview_id=" + technical_interview_id +
                ", mark_of_interview_id=" + mark_of_interview_id +
                '}' + "\n";
    }
}
