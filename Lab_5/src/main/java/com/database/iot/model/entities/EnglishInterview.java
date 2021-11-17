package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "english_interview")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class EnglishInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level_of_technical", length = 45)
    private String level_of_technical;
    @Column(name = "level_of_speaking")
    private String level_of_speaking;
    @Column(name = "general_level")
    private String general_level;

    public EnglishInterview(Integer id, String level_of_technical, String level_of_speaking, String general_level) {
        this.id = id;
        this.level_of_technical = level_of_technical;
        this.level_of_speaking = level_of_speaking;
        this.general_level = general_level;
    }

    @Override
    public String toString(){
        return "English interview {"
                + "id =" + id + ", "
                + "Level of technical = " + level_of_technical + ", "
                + "Level of speaking =" + level_of_speaking + ", "
                + "General level = " + general_level + ", "
                + "};"  + "\n";
    }

}
