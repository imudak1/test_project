package com.example.demo.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private String username;
    private String password;
}
