package com.sberbank.sberstart.users;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USERS_SEQ", allocationSize = 1)
@Accessors(chain = true)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ABOUT")
    private String about;
}
