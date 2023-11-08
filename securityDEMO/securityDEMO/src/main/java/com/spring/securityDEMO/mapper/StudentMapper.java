package com.spring.securityDEMO.mapper;

import com.spring.securityDEMO.entity.dto.StudentDTO;
import com.spring.securityDEMO.entity.pojo.Phone;
import com.spring.securityDEMO.entity.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public Student toEntity(StudentDTO studentDTO) {

        Function<Map<Long, String>, List<Phone>> f = m -> {
          Set<Long> numbers = m.keySet();
          List<Phone> phones = numbers.stream().map(number -> {
              String type = m.get(number);
              return new Phone(type, number);
          }).collect(Collectors.toList());
          return phones;
        };

        List<Phone> phones = f.apply(studentDTO.getPhones());
        return new Student(
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                phones
        );
    }

    public StudentDTO toDTO(Student student) {

        Function<List<Phone>, Map<Long, String>> phonesDTO = phones -> {
            Map<Long, String> dto = new HashMap<>();
            phones.stream().forEach(phone -> {
                String type = phone.getType();
                long number = phone.getNumber();
                if (!dto.containsKey(number)) {
                    dto.put(number, type);
                }
            });
            return dto;
        };

        return new StudentDTO(
                student.getFirstName(),
                student.getLastName(),
                phonesDTO.apply(student.getPhones())
                );
    }
}
