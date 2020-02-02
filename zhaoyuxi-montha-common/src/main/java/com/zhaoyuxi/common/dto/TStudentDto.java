package com.zhaoyuxi.common.dto;

import lombok.Data;

import java.util.List;


@Data
public class TStudentDto extends Page{
    private Integer id;
    private String name;
    private String stuNo;
    private String courseName;
    private String tStudentDtos;
}
