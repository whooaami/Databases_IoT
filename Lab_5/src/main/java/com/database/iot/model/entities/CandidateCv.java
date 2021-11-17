package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "candidate_cv")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class CandidateCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "job", length = 45)
    private String job;
    @Column(name = "work_experience")
    private String work_experience;
    @Column(name = "place_of_study")
    private String place_of_study;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "skills")
    private String skills;

    public CandidateCv(Integer id, String job, String work_experience, String place_of_study,
                       String hobby, String skills){
        this.id = id;
        this.job = job;
        this.work_experience = work_experience;
        this.place_of_study = place_of_study;
        this.hobby = hobby;
        this.skills = skills;
    }

    @Override
    public String toString(){
        return "Candidate CV {"
                + "id =" + id + ", "
                + "Job = " + job + ", "
                + "Work experience = " + work_experience + ", "
                + "Place of study =" + place_of_study + ", "
                + "Hobby = " + hobby + ", "
                + "Skills =" + skills + ", "
                + "};"  + "\n";
    }

}
