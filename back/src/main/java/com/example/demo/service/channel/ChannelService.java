package com.example.demo.service.channel;

import com.example.demo.model.channel.dto.ChannelDto;
import com.example.demo.model.users.dto.UserDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ChannelService {
    ChannelDto register(ChannelDto channelDto);


    ChannelDto loadChannelByUsername(String username)throws UsernameNotFoundException;
}
