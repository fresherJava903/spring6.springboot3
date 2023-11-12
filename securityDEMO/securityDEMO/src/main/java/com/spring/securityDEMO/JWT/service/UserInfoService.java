package com.spring.securityDEMO.JWT.service;
import com.spring.securityDEMO.JWT.encoder.EncoderFactory;
import com.spring.securityDEMO.JWT.encoder.EncoderType;
import com.spring.securityDEMO.JWT.entity.UserInfo;
import com.spring.securityDEMO.JWT.entity.UserInfoDetails;
import com.spring.securityDEMO.JWT.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    private UserInfoRepository repository;
    private EncoderFactory encoderFactory;

    @Autowired
    public UserInfoService(UserInfoRepository repository, EncoderFactory encoderFactory) {
        this.repository = repository;
        this.encoderFactory = encoderFactory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userDetail = repository.findByUsername(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoderFactory.get(EncoderType.BCRYPT).encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }

}
