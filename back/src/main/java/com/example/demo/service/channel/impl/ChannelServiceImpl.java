package com.example.demo.service.channel.impl;

import com.example.demo.Repository.channel.ChannelRepository;
import com.example.demo.model.channel.dto.ChannelDto;
import com.example.demo.model.channel.entity.ChannelEntitiy;
import com.example.demo.service.channel.ChannelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public ChannelDto register(ChannelDto channelDto){
        ChannelEntitiy channelEntitiy=new ModelMapper().map(channelDto,ChannelEntitiy.class);
        ChannelEntitiy savedChannelEntity=channelRepository.save(channelEntitiy);
        return new ModelMapper().map(savedChannelEntity,ChannelDto.class);

    }


    @Override
    public ChannelDto loadChannelByUsername(String username){
        ChannelEntitiy channelEntitiy=channelRepository.findByUsername(username);
        ChannelDto channelDto=new ChannelDto();
        channelDto.setUsername(null);
        if(channelEntitiy!=null){
            channelDto.setAdmin(channelEntitiy.getAdmin());
            channelDto.setMembers(channelEntitiy.getMembers().toArray(new String[0]));

        }
        return channelDto;
    }
}
