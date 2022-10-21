package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: rich
 * @date: 2022/10/21 19:38
 * @description:
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
