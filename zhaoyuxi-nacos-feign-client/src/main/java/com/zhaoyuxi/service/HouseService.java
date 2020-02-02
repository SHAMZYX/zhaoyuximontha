package com.zhaoyuxi.service;

import com.zhaoyuxi.common.dto.THouseDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "nacos-jpa-server")
public interface HouseService {
    @RequestMapping("/house/namelist")
    public ResultEntity houseNameList();

    @RequestMapping("/house/add")
    public ResultEntity houseAdd(@RequestBody THouseDto tHouseDto);
}
