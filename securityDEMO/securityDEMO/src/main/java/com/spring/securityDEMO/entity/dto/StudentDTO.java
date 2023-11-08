package com.spring.securityDEMO.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    String firstName;
    String lastName;
    Map<Long, String> phones;
}
