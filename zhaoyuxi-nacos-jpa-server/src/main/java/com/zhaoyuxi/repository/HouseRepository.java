package com.zhaoyuxi.repository;

import com.zhaoyuxi.entity.THouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<THouse,Integer>, JpaSpecificationExecutor<THouse>, PagingAndSortingRepository<THouse,Integer> {

    public void deleteTHouseByStuId(Integer stuid);
}
