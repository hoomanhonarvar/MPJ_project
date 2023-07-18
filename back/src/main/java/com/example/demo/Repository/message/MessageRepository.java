package com.example.demo.Repository.message;


import com.example.demo.model.message.entity.MessageEntity;
import com.example.demo.model.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    MessageEntity findAllBySender (String sender);
}
