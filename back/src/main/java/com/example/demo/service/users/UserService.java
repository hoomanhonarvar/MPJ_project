package com.example.demo.service.users;

import com.example.demo.model.users.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
     UserDto register (UserDto userDto);

     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;

//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
//     UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;

}
