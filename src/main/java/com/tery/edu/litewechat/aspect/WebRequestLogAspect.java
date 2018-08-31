package com.tery.edu.litewechat.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wanglei on 2018/7/5 上午10:30
 **/
@Slf4j
@Aspect
@Component
public class WebRequestLogAspect extends HandlerInterceptorAdapter {


    @Pointcut("execution(public * com.tery.edu.litewechat.api..*.*(..))")
    public void webRequestLog() {
    }

    @Before("webRequestLog()")
    public void before(JoinPoint point) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String className = point.getSignature().getDeclaringTypeName();
            String methodName = point.getSignature().getName();
            String uri = request.getRequestURI();
            String remoteAddr = request.getRemoteAddr();
            String sessionId = request.getSession().getId();
            String method = request.getMethod();
            String params = null;
            if (Objects.equals(method, "POST")) {
                Object[] paramsArray = point.getArgs();
                params = Arrays.toString(paramsArray);
            } else {
                Map<?, ?> paramsMap = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                params = paramsMap.toString();
            }
            log.info( ">>>REQUEST:{uri=" + uri + "; className=" + className + "; remoteAddr=" + remoteAddr
                    + "; methodName=" + methodName + "; sessionId=" + sessionId+ "; params=" + params+"}");
        } catch (Exception e) {
            throw new RuntimeException("请求失败：" + e);
        }
    }

    @AfterReturning(returning = "result", pointcut = "webRequestLog()")
    public void doAfterReturning(Object result) {
        try {
            // 处理完请求，返回内容
            if (result instanceof String) {
            } else {
                result = JSONObject.toJSONString(result);
            }
            log.info(">>>RESPONSE:{" + result+"}");
        } catch (Exception e) {
            log.error("***操作请求日志记录失败doAfterReturning()***", e);
        }
    }
}
