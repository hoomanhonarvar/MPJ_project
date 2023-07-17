package com.example.demo.service.impl;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder ;
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {

        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }


   @Override
   public UserDto register(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setRole("USER");
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setUsername(userDto.getUsername());

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return new ModelMapper().map(savedUserEntity,UserDto.class);
   }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity==null){
            throw new UsernameNotFoundException("ajab");
        }
        List<GrantedAuthority> authorities =new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));

        return new User(userEntity.getUsername(),userEntity.getPassword(),authorities);



    }

//    public Stream<UserEntity>getAllUsers(){
//        return UserRepository.findAll().stream();
//    }
}
