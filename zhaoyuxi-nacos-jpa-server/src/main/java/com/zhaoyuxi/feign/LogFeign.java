package com.zhaoyuxi.feign;



import com.zhaoyuxi.common.dto.LogDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "mongodb")
public interface LogFeign {


    @RequestMapping(value = "/log/add",method = RequestMethod.POST)
    public ResultEntity add(LogDto logDto);
}
