package com.zhaoyuxi.service;

import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.entity.TStudent;
import org.springframework.data.domain.Page;


public interface StudentService {
    Page<TStudent> getStudentsPage(TStudentDto tStudentDto);

    TStudent studentAdd(TStudentDto tStudentDto);

    void studentDel(TStudentDto tStudentDto);

    TStudent studentFindOne(TStudentDto tStudentDto);
}
