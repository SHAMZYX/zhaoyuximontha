package com.zhaoyuxi.service;

import com.zhaoyuxi.common.dto.THouseDto;
import com.zhaoyuxi.entity.THouse;

import java.util.List;

public interface HouseService {
    List<THouse> getHousesAll();
    THouse houseAdd(THouseDto tHouseDto);
}
