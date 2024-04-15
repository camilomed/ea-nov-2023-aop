package com.example.springdata.aspects;


import com.example.springdata.Repository.ActivityLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.time.LocalDateTime;

@Component
@Aspect
public class AspectL {

    @Autowired
    ActivityLogRepository activityLogRepository;

    @Before("within(com.example.springdata.*)")
    public  void checkAopIsAwesomeHeader(){

        HttpServletRequest requestAttri = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String typeHttp= requestAttri.getMethod();
        if(typeHttp.equals("POST")){
            String head= requestAttri.getHeader("AOP-IS-AWESOME");
            if (head==null) throw new AopIsAwesomeHeaderException("missing header");
        }
    }

    @Around("@annotation(executionTIme)")
    public Object logExecutionTIme(ProceedingJoinPoint proceedingJoinPoint, ExecutionTime executionTIme) throws  Throwable{
        long startime= System.currentTimeMillis();
        String nameClass =proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String nameMethod = proceedingJoinPoint.getSignature().getName();
        Object proceed = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        ActivityLog activityLog = ActivityLog.builder()
                .date(LocalDateTime.now())
                .operation(nameClass + "." + nameMethod)
                .duration(endTime-startime)
                .build();
        activityLogRepository.save(activityLog);
        return proceed;
    }

}
