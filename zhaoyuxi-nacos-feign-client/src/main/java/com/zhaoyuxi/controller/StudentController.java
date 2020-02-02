package com.zhaoyuxi.controller;

import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import com.zhaoyuxi.service.StudentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 返回学生列表
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity studentList(TStudentDto tStudentDto){
        ResultEntity resultEntity = studentService.studentList(tStudentDto);
        return  resultEntity;
    }

    /**
     * 添加学生信息
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/add")
    public ResultEntity studentAdd(TStudentDto tStudentDto){
        ResultEntity resultEntity = studentService.studentAdd(tStudentDto);
        return resultEntity;
    }

    /**
     * 删除学生信息
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/del")
    public ResultEntity studentDel( TStudentDto tStudentDto){
        ResultEntity resultEntity = studentService.studentDel(tStudentDto);
        return resultEntity;
    }

    /**
     * 根据学号查询学生
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/one")
    public ResultEntity findOne( TStudentDto tStudentDto){
        ResultEntity one = studentService.findOne(tStudentDto);
        return one;
    }
}
