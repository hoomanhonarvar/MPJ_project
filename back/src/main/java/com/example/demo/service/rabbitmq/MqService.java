package com.example.demo.service.rabbitmq;

import com.example.demo.model.channel.dto.ChannelDto;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface MqService {
    void new_queue(String username);

    void new_channel(ChannelDto channelDto) throws IOException, TimeoutException;
}
