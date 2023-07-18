package com.example.demo.service.users;

import com.example.demo.model.users.dto.UserDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
     UserDto register (UserDto userDto);

     UserDto loadUserByUsername(String username)throws UsernameNotFoundException;

    boolean equalshash(Object o);

//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;

}
