package com.study.aop;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: komi
 * @Date: 2018/5/22 11:10
 */
@Aspect
@Order(1)
@Component
public aspect LoggingAspect3 {
    private Logger logger = Logger.getLogger(LoggingAspect3.class);

    @Pointcut("execution(public * com.study.controller.* (..))")
    public void apiLogAspect() {

    }

    @Before("apiLogAspect()")
    public void dobefore(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 使用log4j的MDC及NDC特性，识别请求方的IP及调用资料，输出到日志中
        MDC.put("uri", request.getRequestURI());
        NDC.push(request.getRemoteAddr());
        // 记录下请求内容
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        NDC.pop();
        NDC.remove();
        MDC.get("uri");
        MDC.remove("uri");
    }

    @AfterReturning(value="apiLogAspect()",returning = "ret")
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容
        logger.info("RESPONSE : "+ret);
    }
}
