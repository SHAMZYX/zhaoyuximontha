package com.zhaoyuxi.controller;

import com.zhaoyuxi.annotations.Log;
import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import com.zhaoyuxi.entity.TStudent;
import com.zhaoyuxi.service.StudentService;
import org.springframework.data.domain.Page;
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
     * 返回学生信息列表
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/list")
    @Log(value = "查询学生列表")
    public ResultEntity studentList(@RequestBody TStudentDto tStudentDto){
        Page<TStudent> studentsPage = studentService.getStudentsPage(tStudentDto);
        ResultEntity ok = ResultEntity.ok(studentsPage);
        return ok;
    }

    /**
     * 添加学生信息
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/add")
    public ResultEntity studentAdd(@RequestBody TStudentDto tStudentDto){
        TStudent tStudent = studentService.studentAdd(tStudentDto);
        ResultEntity ok = ResultEntity.ok(tStudent);
        return ok;
    }

    /**
     * 删除学生信息
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/del")
    public ResultEntity studentDel(@RequestBody TStudentDto tStudentDto){
        studentService.studentDel(tStudentDto);
        return ResultEntity.ok();
    }

    /**
     * 根据学号查询学生
     * @param tStudentDto
     * @return
     */
    @RequestMapping("/one")
    public ResultEntity findOne(@RequestBody TStudentDto tStudentDto){
        TStudent tStudent = studentService.studentFindOne(tStudentDto);
        ResultEntity resultEntity=ResultEntity.ok(tStudent);
        return resultEntity;
    }

}
