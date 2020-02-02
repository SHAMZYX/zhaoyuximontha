package com.zhaoyuxi.controller;

import com.zhaoyuxi.common.dto.THouseDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import com.zhaoyuxi.entity.THouse;
import com.zhaoyuxi.service.HouseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    private HouseService houseService;

    /**
     * 获取不带重复的科目名字集合
     * @return
     */
    @RequestMapping("/namelist")
    public ResultEntity houseNameList(){
        List<THouse> housesAll = houseService.getHousesAll();
        List<String> namelist=housesAll.stream().map(THouse::getCourseName).collect(Collectors.toList());
        List<String> names=namelist.stream().distinct().collect(Collectors.toList());
        ResultEntity ok = ResultEntity.ok(names);
        return ok;
    }

    /**
     * 添加课程分数信息
     * @param tHouseDto
     * @return
     */
    @RequestMapping("/add")
    public ResultEntity houseAdd(@RequestBody THouseDto tHouseDto){
        THouse tHouse = houseService.houseAdd(tHouseDto);
        ResultEntity ok = ResultEntity.ok(tHouse);
        return ok;
    }
}
