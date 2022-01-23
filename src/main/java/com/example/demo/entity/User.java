package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity(name = "users")
@Data
@EqualsAndHashCode
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
