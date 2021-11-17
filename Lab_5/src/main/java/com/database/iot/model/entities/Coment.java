package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "coment")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Coment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rating", length = 45)
    private Integer rating;
    @Column(name = "response")
    private String response;

    public Coment(Integer id, Integer rating, String response) {
        this.id = id;
        this.rating = rating;
        this.response = response;
    }

    @Override
    public String toString(){
        return "Coment {"
                + "id =" + id + ", "
                + "Rating = " + rating + ", "
                + "Response =" + response + ", "
                + "};"  + "\n";
    }

}
