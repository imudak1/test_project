package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfileDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    private String address;
}
