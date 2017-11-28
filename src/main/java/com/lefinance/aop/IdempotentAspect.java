package com.lefinance.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Jingyan
 * @Time: 2017-11-28 14:32
 * @Description:
 */
@Aspect
@Component
@Order(1)
public class IdempotentAspect {

    private static Logger logger = LoggerFactory.getLogger(IdempotentAspect.class);
    private static final String POINT_CUT = "execution(public * com..*.service.impl.*.*(..)) && @annotation(idempotent)";

    /**
     * Created with Jingyan
     * Time: 2017-11-28 18:04
     * Description: constructor
     */
    public IdempotentAspect() {
    }

    /**
     * Created with Jingyan
     * Time: 2017-11-28 18:45
     * Description:
     * 定义一个切入点 { public 任意类型返回值 com.任意业务包.service.impl.任意类.任意方法.(任意多个参数) && 有注解(Idempotent) }
     */
    @Before(value = "execution(public * com..*.service.impl.*.*(..)) && @annotation(idempotent)")
    public boolean doBefore(JoinPoint joinPoin,Idempotent idempotent) {
        logger.debug("doBefore(invokeIdempotent())");
        Object[] params = joinPoin.getArgs();
        if (null != params && params.length > 0) {
            for (Object obj:params) {
                if(obj instanceof BaseVo){
                    //TODO 幂等判断操作
                    BaseVo baseVo=(BaseVo) obj;
                    if(baseVo.getUuid().equals("1")){
                        baseVo.setSuccess(true);
                    }else {
                        baseVo.setSuccess(false);
                    }
                }
            }
        }
        return true;
    }

}