package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {

    public static final String CONTEXT_ATTRIBUTE_TIME_INIT = "servletTimeInit";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(CONTEXT_ATTRIBUTE_TIME_INIT,
                LocalDateTime.now());
    }
}
