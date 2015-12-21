package com.root.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.root.p1.common.Constants;

@Aspect
@Component
public class RootLogger {

    // Logger defination
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    // Get class name
    private String getClassName(JoinPoint jp) {
        String clazzName = jp.getTarget().getClass().getName() + " ";
        return clazzName;
    }
    
    // Get method name
    private String getMethodName(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        return methodName;
    }
    
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping(){};
    
    @Pointcut("execution(* com.root..*(..))")
    public void methodPointcut(){};
    
    @Before(value="methodPointcut()")
    public void loggingBefore(JoinPoint jp) throws Throwable {
        log.info(Constants.LOGMSG_START_METHOD + getClassName(jp) + getMethodName(jp));
    }
    
    @After(value="methodPointcut()")
    public void loggingAfter(JoinPoint jp) throws Throwable {
        log.info(Constants.LOGMSG_STOP_METHOD + getClassName(jp) + getMethodName(jp));
    }
}