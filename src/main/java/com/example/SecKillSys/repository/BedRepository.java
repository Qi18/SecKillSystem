package com.example.SecKillSys.repository;

import com.example.SecKillSys.po.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 14:38
 * @description:
 */
public interface BedRepository extends JpaRepository<Bed, Integer> {

    List<Bed> findAllByRid(Integer room_id);

    @Query(value = "select * from Beds b where b.room_id = ?1 and b.status = 0",nativeQuery = true)
    List<Bed> findAllEmptyByRid(Integer room_id);
}
