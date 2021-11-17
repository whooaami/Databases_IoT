package com.database.iot.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact_person")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class ContactPerson {
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

    public ContactPerson(Integer id, String name, String surname, Integer phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number=" + phone_number +
                '}' + "\n";
    }
}
