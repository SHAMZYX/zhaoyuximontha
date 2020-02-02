package com.zhaoyuxi.controller;

import com.zhaoyuxi.common.dto.THouseDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import com.zhaoyuxi.service.HouseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    private HouseService houseService;

    /**
     * 返回名称列表
     * @return
     */
    @RequestMapping("/namelist")
    public ResultEntity houseNameList(){
        ResultEntity resultEntity = houseService.houseNameList();
        return resultEntity;
    }

    /**
     * 添加课程分数信息
     * @param tHouseDto
     * @return
     */
    @RequestMapping("/add")
    public ResultEntity houseAdd(THouseDto tHouseDto){
        ResultEntity resultEntity = houseService.houseAdd(tHouseDto);
        return  resultEntity;
    }
}
