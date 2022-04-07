package org.xiong.utils.log;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class UpLogFun {

    @Around("@annotation(upLog)")
    public Object around(ProceedingJoinPoint point, UpLog upLog) throws Throwable {
        String name  = upLog.value();
        if (StrUtil.isEmpty(name)){
            name = point.getSignature().getName();
        }
        log.info(name+"方法执行开始-----");
        Date startTime = new Date();
        Object o = point.proceed();
        log.info(name+"方法执行结束，总耗时：【"+(DateUtil.between(startTime, new Date(), DateUnit.SECOND))+"】秒-----");
        return o;
    }
}