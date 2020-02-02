package com.zhaoyuxi.common.dto;

import lombok.Data;

@Data
public class THouseDto extends Page {
    private Integer id;
    private String courseName;
    private Integer fraction;
    private Integer stuId;
}
