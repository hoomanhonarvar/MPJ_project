package com.example.demo.Repository.channel;


import com.example.demo.model.channel.entity.ChannelEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntitiy,Long> {
}
