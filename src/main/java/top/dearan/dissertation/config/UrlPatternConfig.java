package top.dearan.dissertation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author : dingshuangen
 * @Date : 2019/6/3 0003
 */
//@Configuration
public class UrlPatternConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 自定义项目的资源路径
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/home/ding/java-project/dissertation/sources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }
}

