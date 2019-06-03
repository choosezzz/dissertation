package top.dearan.dissertation.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dearan.dissertation.config.PythonConfig;
import top.dearan.dissertation.web.model.ResponseVO;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/13 14:14
 *
 * Python 程序调用服务
 */
@Service
@Slf4j
public class PythonCallerService {

    @Autowired
    private PythonConfig pythonConfig;

    public ResponseVO<String> imageIdentification(String imagePath){

        String trace = String.valueOf(System.currentTimeMillis());
        log.info("imageIdentification --> start 【trace:{}】",trace);

        if (StringUtils.isEmpty(imagePath)){
            return new ResponseVO<>(400,"image upload failed");
        }
        Process process;
        String savePath = null;
        try {
             savePath = System.getProperty("user.dir")+pythonConfig.getImageSavePath();

            File file = new File(savePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            String[] args = {pythonConfig.getCommand(),pythonConfig.getProcessPath(),pythonConfig.getImageExecType(),imagePath,savePath};
            log.info("imageIdentification --> start 【trace:{},args:{}】",trace,args);
            process = Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                log.info("调用python >>> {}",line);
                if (line.startsWith(pythonConfig.getErrorPrefix())){
                    return new ResponseVO<>(400,line.replace(pythonConfig.getErrorPrefix(),""));
                }else if (line.startsWith(pythonConfig.getSuccessPrefix())){
                    String result = line.replace(pythonConfig.getSuccessPrefix(), "");
                    return new ResponseVO<>(200,"success","../static/image/"+getFileName(result));
                }
            }
            in.close();
            process.waitFor();
        }catch (IOException e){
            log.error("imageIdentification --> error 【trace:{}】",trace,e);
        }catch (InterruptedException e){
            log.error("imageIdentification --> error 【trace:{}】",trace,e);
        }
        return new ResponseVO<>(500,"error");
    }

    private String getFileName(String path){

        if (StringUtils.isEmpty(path)){
            return null;
        }
        int k = path.lastIndexOf("/");
        int m = path.lastIndexOf("\\");
        int index = k>m?k:m;
        return path.substring(k+1);
    }

}
