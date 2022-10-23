package com.example.SecKillSys.po;


import com.example.SecKillSys.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nums")
    private Integer nums;

    @Column(name = "remain_nums")
    private Integer remainNums;

    @Column(name = "building_id")
    private Integer bid;

    @Column(name = "gender")
    private Gender gender;

//    @Transient
//    private List<Bed> beds;

}

