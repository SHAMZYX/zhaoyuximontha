package com.zhaoyuxi;

import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.entity.TStudent;
import com.zhaoyuxi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ZhaoyuxiNacosJpaServerApplicationTests {

    @Resource
    private StudentService studentService;

    @Test
    void contextLoads() {
        TStudentDto tStudent= new TStudentDto();
        tStudent.setPageNo(1);
        tStudent.setPageSize(3);
        Page<TStudent> studentsPage = studentService.getStudentsPage(tStudent);
        for (TStudent student : studentsPage) {
            System.out.println(student);
        }
    }

}
