package top.dearan.dissertation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author : dingshuangen
 * @Date : 2019/1/13 0013
 */

@Service
public class FileUploadService {

    @Value("${upload.file.save-path}")
    String saveFolder;

    public String saveFile(MultipartFile file) {

        if (null == file || file.getSize()<=0){
            return null;
        }
        String result = null;
        try {
            result = new File(System.getProperty("user.dir")).getParent() + saveFolder;
            File folder = new File(result);
            if (!folder.exists()){
                folder.mkdir();
            }
            file.transferTo(new File(result+file.getOriginalFilename()));
            return result+file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
