package top.dearan.dissertation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/13 14:20
 */
@Configuration
public class PythonConfig {

    @Value("${python.command}")
    private String command;
    @Value("${python.image-exec-type}")
    private String imageExecType;
    @Value("${python.video-exec-type}")
    private String videoExecType;
    @Value("${python.result.error-prefix}")
    private String errorPrefix;
    @Value("${python.result.success-prefix}")
    private String successPrefix;

    @Value("${python.process.path}")
    private String processPath;
    @Value("${python.result.image-save-path}")
    private String imageSavePath;
    @Value("${python.result.video-save-path}")
    private String videoSavePath;
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getImageExecType() {
        return imageExecType;
    }

    public void setImageExecType(String imageExecType) {
        this.imageExecType = imageExecType;
    }

    public String getVideoExecType() {
        return videoExecType;
    }

    public void setVideoExecType(String videoExecType) {
        this.videoExecType = videoExecType;
    }

    public String getErrorPrefix() {
        return errorPrefix;
    }

    public void setErrorPrefix(String errorPrefix) {
        this.errorPrefix = errorPrefix;
    }

    public String getSuccessPrefix() {
        return successPrefix;
    }

    public void setSuccessPrefix(String successPrefix) {
        this.successPrefix = successPrefix;
    }

    public String getProcessPath() {
        return processPath;
    }

    public void setProcessPath(String processPath) {
        this.processPath = processPath;
    }

    public String getImageSavePath() {
        return imageSavePath;
    }

    public void setImageSavePath(String imageSavePath) {
        this.imageSavePath = imageSavePath;
    }

    public String getVideoSavePath() {
        return videoSavePath;
    }

    public void setVideoSavePath(String videoSavePath) {
        this.videoSavePath = videoSavePath;
    }
}
