package com.hualala;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by huzhe on 2018/03/29.
 */
@SpringBootApplication
@ComponentScan
@EnableScheduling
@EnableAsync
@SpringBootConfiguration
@EnableCaching
public class ServiceApplication implements EmbeddedServletContainerCustomizer {

    private static Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(ServiceApplication.class, args);
        logger.info("service start success .....");
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8881);
    }
}
