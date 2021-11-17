package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mark_of_interview")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class MarkOfInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level", length = 45)
    private String level;
    @Column(name = "coment_id")
    private Integer coment_id;

    public MarkOfInterview(Integer id, String level, Integer coment_id) {
        this.id = id;
        this.level = level;
        this.coment_id = coment_id;
    }

    @Override
    public String toString(){
        return "Mark of interview {"
                + "id =" + id + ", "
                + "Level = " + level + ", "
                + "Coment id =" + coment_id + ", "
                + "};"  + "\n";
    }

}
