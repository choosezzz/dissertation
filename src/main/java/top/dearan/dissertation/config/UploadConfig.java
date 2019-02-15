package top.dearan.dissertation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @Author : dingshuangen
 * @Date : 2019/1/13 0013
 */
@Configuration
public class UploadConfig {

    @Value("${upload.file.max-size}")
    private long maxSize ;
    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize(DataSize.ofBytes(maxSize));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofBytes(maxSize));
        //设置上传临时文件目录
        //factory.setLocation("/data/tmp");

        return factory.createMultipartConfig();
    }
}
