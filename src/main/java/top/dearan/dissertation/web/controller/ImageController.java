package top.dearan.dissertation.web.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dearan.dissertation.service.FileUploadService;
import top.dearan.dissertation.service.PythonCallerService;
import top.dearan.dissertation.web.model.ResponseVO;

import javax.validation.Valid;


/**
 * @Author : dingshuangen
 * @Date : 2019/1/13 0013
 */
@Slf4j
@RestController
@RequestMapping("/image/upload")
public class ImageController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private PythonCallerService pythonCallerService;
    @RequestMapping("/spot")
    public ResponseVO spot(@Valid MultipartFile file){
        String s = fileUploadService.saveFile(file);
        ResponseVO<String> stringResponseVO = pythonCallerService.imageIdentification(s);
        log.info("image spot end : 【result:{}】", JSONObject.toJSONString(stringResponseVO));
        return stringResponseVO;
    }

}
