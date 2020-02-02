package com.zhaoyuxi.aop;


import com.alibaba.fastjson.JSON;

import com.zhaoyuxi.annotations.Log;
import com.zhaoyuxi.common.dto.LogDto;
import com.zhaoyuxi.common.vo.ResultEntity;
import com.zhaoyuxi.feign.LogFeign;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Slf4j
@Component
public class LogAop {

    @Pointcut("execution(* com.zhaoyuxi.controller.*.*(..))")
    public void  pointcut(){}


    @Resource
    LogFeign logFeign;
    @AfterReturning(value = "pointcut()")
    public void after(JoinPoint joinPoint){

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Log annotation = method.getAnnotation(Log.class);
        if (annotation!=null){
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();

            LogDto logDto = new LogDto();
            logDto.setUrl(request.getRequestURI());
            logDto.setIp(request.getRemoteAddr());
            logDto.setPort(request.getServerPort()+"");
            logDto.setMethod(request.getMethod());
            logDto.setDesc(annotation.value());
            logDto.setArgs(joinPoint.getArgs());
            logDto.setStudentname(request.getSession().getAttribute("user")==null?"":request.getSession().getAttribute("user").toString());

            ResultEntity add = logFeign.add(logDto);
            log.info("aop 添加日志返回结果为:{}", JSON.toJSONString(add));

        }

    }

}
