package com.example.demo.service.users.impl;

import com.example.demo.Repository.users.UserRepository;
import com.example.demo.model.users.dto.UserDto;
import com.example.demo.model.users.entity.UserEntity;
import com.example.demo.service.users.UserService;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository=userRepository;
    }


   @Override
   public UserDto register(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setRole("USER");
        userEntity.setPass(userDto.getPassword());
        userEntity.setUsername(userDto.getUsername());

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return new ModelMapper().map(savedUserEntity,UserDto.class);
   }

    @Override
    public UserDto loadUserByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        UserDto userDto=new UserDto();
        userDto.setUsername(null);
//        if(userEntity==null){
//            throw new UsernameNotFoundException("Username not found");
//        }
//        List<GrantedAuthority> authorities =new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));
////        UserDetails userDetails = new UserDetails();
        if(userEntity!=null){
        userDto.setPass(userEntity.getPass());
        userDto.setUsername(userEntity.getUsername());}

//        UserDto map = new ModelMapper().map(userEntity, UserDto.class);
        return userDto;



    }
    @Override
    public boolean equalshash(Object o){
        if (this==o)
            return true;

        else if(o==null||this.getClass()!=o.getClass())
            return false;


        return false;
    }

//


}
