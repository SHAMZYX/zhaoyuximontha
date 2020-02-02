package com.zhaoyuxi.service;

import com.zhaoyuxi.common.dto.TStudentDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "nacos-jpa-server")
public interface StudentService {
    @RequestMapping("/student/list")
    public ResultEntity studentList(@RequestBody TStudentDto tStudentDto);
    @RequestMapping("/student/add")
    public ResultEntity studentAdd(@RequestBody TStudentDto tStudentDto);
    @RequestMapping("/student/del")
    public ResultEntity studentDel(@RequestBody TStudentDto tStudentDto);
    @RequestMapping("/student/one")
    public ResultEntity findOne(@RequestBody TStudentDto tStudentDto);
}
