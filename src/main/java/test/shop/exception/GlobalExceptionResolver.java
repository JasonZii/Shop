package test.shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.22  14:35
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception e) {

        //打印控制台
        e.printStackTrace();

        //向日志文件中写入异常
        LOGGER.info("全局异常处理器...");
        LOGGER.debug("123"+handler.getClass());
        LOGGER.error("系统发生异常...",e);
        //写日志
        //发邮件
        //显示错误
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception");


        return modelAndView;
    }
}
