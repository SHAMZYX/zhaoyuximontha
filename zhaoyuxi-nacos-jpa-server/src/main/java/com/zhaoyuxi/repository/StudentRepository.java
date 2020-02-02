package com.zhaoyuxi.repository;

import com.zhaoyuxi.entity.TStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<TStudent,Integer>, JpaSpecificationExecutor<TStudent>, PagingAndSortingRepository<TStudent,Integer> {
    Page<TStudent> findAll(Specification<TStudent> specification, Pageable pageable);

    TStudent findTStudentByStuNo(String stuNo);
}
