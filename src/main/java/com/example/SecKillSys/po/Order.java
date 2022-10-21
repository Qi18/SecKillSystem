package com.example.SecKillSys.po;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_id")
    private Integer gid;

    @Column(name = "building_id")
    private Integer bid;

    @Column(name = "status")
    private Integer status;

    @Column(name = "room_id")
    private Integer rid;

}

