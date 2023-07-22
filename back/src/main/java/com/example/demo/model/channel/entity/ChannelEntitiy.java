package com.example.demo.model.channel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "channels")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChannelEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String username;
    private String admin;
//    private List<String> members=new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "members",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "members")
    private List<String> members=new ArrayList<>();
    private int numberofmembers;


}
