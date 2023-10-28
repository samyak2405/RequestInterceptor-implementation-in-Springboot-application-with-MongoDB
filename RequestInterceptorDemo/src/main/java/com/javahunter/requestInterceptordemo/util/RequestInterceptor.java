package com.javahunter.requestInterceptordemo.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object  object){
        log.info("1 - pre handle.");
        log.info("METHOD type: {}",request.getMethod());
        log.info("Request URI: {}",request.getRequestURI());
        log.info("Servlet PATH: {}",request.getServletPath());

        if(object instanceof HandlerMethod){
            Class<?> controllerClass = ((HandlerMethod)object).getBeanType();
            String methodName = ((HandlerMethod)object).getMethod().getName();
            log.info("Controller name: {}",controllerClass.getName());
            log.info("Method name: {}",methodName);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView){
        log.info("2 - post handle.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object object, Exception exception){
        if(exception!=null){
           log.info("An error occurred");
        }
        log.info("3 - After completion");
    }
}
