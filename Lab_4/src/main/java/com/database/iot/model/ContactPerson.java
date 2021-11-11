package com.database.iot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class ContactPerson {
    private Integer id;
    private String name;
    private String surname;
    private Integer phone_number;

    public ContactPerson(String name, String surname, Integer phone_number) {
        this(null, name, surname, phone_number);
    }
}
