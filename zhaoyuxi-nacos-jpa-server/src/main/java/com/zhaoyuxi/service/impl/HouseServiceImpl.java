package com.zhaoyuxi.service.impl;

import com.zhaoyuxi.common.dto.THouseDto;
import com.zhaoyuxi.entity.THouse;
import com.zhaoyuxi.repository.HouseRepository;
import com.zhaoyuxi.service.HouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseRepository houseRepository;

    @Override
    public List<THouse> getHousesAll() {
        return houseRepository.findAll();
    }

    @Override
    public THouse houseAdd(THouseDto tHouseDto) {
        THouse tHouse=new THouse();
        BeanUtils.copyProperties(tHouseDto,tHouse);
        THouse save = houseRepository.save(tHouse);
        return save;
    }
}
