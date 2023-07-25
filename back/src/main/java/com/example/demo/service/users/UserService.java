package com.example.demo.service.users;

import com.example.demo.model.users.dto.UserDto;

public interface UserService {
     UserDto register (UserDto userDto);

     UserDto loadUserByUsername(String username);

    boolean equalshash(Object o);

//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;

}
