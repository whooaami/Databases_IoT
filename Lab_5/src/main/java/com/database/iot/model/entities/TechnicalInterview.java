package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "technical_interview")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class TechnicalInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "programming_language", length = 45)
    private String programming_language;
    @Column(name = "algorithm")
    private String algorithm;
    @Column(name = "data_structure")
    private String data_structure;
    @Column(name = "database")
    private String database;
    @Column(name = "result_interview")
    private String result_interview;


    public TechnicalInterview(Integer id, String programming_language, String algorithm, String data_structure,
                              String database, String result_interview) {
        this.id = id;
        this.programming_language = programming_language;
        this.algorithm = algorithm;
        this.data_structure = data_structure;
        this.database = database;
        this.result_interview = result_interview;
    }

    @Override
    public String toString(){
        return "Technical interview {"
                + "id =" + id + ", "
                + "Programming language = " + programming_language + ", "
                + "Algorithm =" + algorithm + ", "
                + "Data structure = " + data_structure + ", "
                + "Database =" + database + ", "
                + "Result interview = " + result_interview + ", "
                + "};"  + "\n";
    }

}
