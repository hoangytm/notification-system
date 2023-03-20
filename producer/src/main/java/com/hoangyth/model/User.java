package com.hoangyth.model;

import com.hoangyth.validator.Name;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "USER_NAME", length = 2000)
    @Name(max= 1000, min= 3, message="invalid user name")
    private String userName;

}
