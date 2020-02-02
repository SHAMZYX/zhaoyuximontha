package com.zhaoyuxi.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.entity.THouse;
import com.zhaoyuxi.entity.TStudent;
import com.zhaoyuxi.repository.HouseRepository;
import com.zhaoyuxi.repository.StudentRepository;
import com.zhaoyuxi.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private HouseRepository houseRepository;

    @Override
    public Page<TStudent> getStudentsPage(TStudentDto tStudentDto) {
        Pageable pageable = PageRequest.of(tStudentDto.getPageNo() - 1, tStudentDto.getPageSize());
        Specification<TStudent> specification = new Specification<TStudent>() {

            @Override
            public Predicate toPredicate(Root<TStudent> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> p = new ArrayList<>();
                if (StringUtils.isNotBlank(tStudentDto.getName())) {
                    Predicate username = criteriaBuilder.like(root.get("name"), "%".concat(tStudentDto.getName()).concat("%"));
                    p.add(username);
                }
                return criteriaBuilder.and(p.toArray(new Predicate[p.size()]));
            }
        };
        Page<TStudent> all = studentRepository.findAll(specification, pageable);
        return all;
    }

    @Override
    public TStudent studentAdd(TStudentDto tStudentDto) {
        TStudent tStudent=new TStudent();
        BeanUtils.copyProperties(tStudentDto,tStudent);
        TStudent save = studentRepository.save(tStudent);
        if(null!=tStudentDto.getId() &&tStudentDto.getId()!=0){
            houseRepository.deleteTHouseByStuId(tStudentDto.getId());
        }
        List<THouse> tHouses = JSON.parseArray(tStudentDto.getTStudentDtos(), THouse.class);
        for (THouse tHouse : tHouses) {
            tHouse.setId(0);
            tHouse.setStuId(save.getId());
            houseRepository.save(tHouse);
        }
        return save;
    }

    @Override
    public void studentDel(TStudentDto tStudentDto) {
        studentRepository.deleteById(tStudentDto.getId());
    }

    @Override
    public TStudent studentFindOne(TStudentDto tStudentDto) {
        TStudent tStudentByStuNo = studentRepository.findTStudentByStuNo(tStudentDto.getStuNo());
        return tStudentByStuNo;
    }
}
