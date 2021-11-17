package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vacancy")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "job_desciption", length = 45)
    private String job_desciption;
    @Column(name = "project_name")
    private String project_name;


    public Vacancy(Integer id, String job_desciption, String project_name) {
        this.id = id;
        this.job_desciption = job_desciption;
        this.project_name = project_name;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", job_desciption='" + job_desciption + '\'' +
                ", project_name='" + project_name + '\'' +
                '}' + "\n";
    }
}
