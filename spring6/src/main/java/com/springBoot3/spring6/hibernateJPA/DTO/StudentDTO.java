package com.springBoot3.spring6.hibernateJPA.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    String email;
    String firstName;
    String lastName;
}
