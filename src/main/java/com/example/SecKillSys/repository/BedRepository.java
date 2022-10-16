package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 14:38
 * @description:
 */
public interface BedRepository extends JpaRepository<Bed, Integer> {

    List<Bed> findAllByRid(Integer room_id);
}
