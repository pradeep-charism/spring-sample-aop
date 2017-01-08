package com.charism.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Pradeep on 1/8/2017.
 */
@Component
@Aspect
public class TracingAspect {

    Logger logger = LoggerFactory.getLogger(TracingAspect.class);
    boolean enteringCalled = false;

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    @Before("execution(* doSomethingElse(..))")
    public void entering(JoinPoint joinPoint) {
        enteringCalled = true;
        logger.trace("entering :"+ joinPoint.getStaticPart().getSignature().toString());
    }

}
