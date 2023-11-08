package com.spring.securityDEMO.service;

import com.spring.securityDEMO.entity.auth.Authority;
import com.spring.securityDEMO.entity.auth.User;
import com.spring.securityDEMO.entity.dto.UserDTO;
import com.spring.securityDEMO.repository.AuthorityRepo;
import com.spring.securityDEMO.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepo userRepo;
    private AuthorityRepo authorityRepo;
    @Autowired
    public UserService(UserRepo userRepo, AuthorityRepo authorityRepo) {
        this.userRepo = userRepo;
        this.authorityRepo = authorityRepo;
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .toList());
    }

    public List<UserDTO> getUsers() {
        return userRepo.findAll().stream()
                .map(user -> toDTO(user))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User newUser = new User(userDTO.getUsername(), userDTO.getPassword());
        userDTO.getAuthorities().forEach(authority -> {
            Authority entity = authorityRepo.findByAuthority(authority);
            if (null != entity) {
                  newUser.addAuthority(entity);
            } else {
                Authority newRole = new Authority(authority, newUser);
                newUser.addAuthority(newRole);
                authorityRepo.save(newRole);
            }
        });
        userRepo.save(newUser);
        return userDTO;
    }


}
