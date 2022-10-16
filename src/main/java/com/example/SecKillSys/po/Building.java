package com.example.SecKillSys.po;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

//    @Column(name = "inform")
//    private String info;

//    @Transient
//    private List<Level> levels;
//
//    @Transient
//    private Integer remainNums;
//
//    @Transient
//    private Integer nums;

}

