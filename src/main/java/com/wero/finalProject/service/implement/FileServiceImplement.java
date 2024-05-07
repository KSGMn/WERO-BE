package com.wero.finalProject.service.implement;

import com.wero.finalProject.service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


@Service
public class FileServiceImplement implements FileService {

    @Value("${spring.file.upload.path}")
    private String filePath;
    @Value("${spring.file.upload.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {
       if(file.isEmpty()) return null;

       String originalFilename = file.getOriginalFilename();
       String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
       String uuid= UUID.randomUUID().toString();
       String saveFileName = uuid + extension;
       String savePath= filePath+saveFileName;

       try{
            file.transferTo(new File(savePath));
       }catch (Exception exception){
           exception.printStackTrace();
           return null;
       }

       String url=fileUrl+saveFileName;
       return url;

    }

    @Override
    public Resource getImage(String fileName) {

        Resource resource=null;

        try{
            resource = new UrlResource("file"+fileName);


        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
        return  resource;
    }
}
