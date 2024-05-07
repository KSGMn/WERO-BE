package com.wero.finalProject.controller;

import com.wero.finalProject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:FileController.class
 * @기능:
 **/

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String url = fileService.upload(file);
        return url;
    }

    @GetMapping(value = "{fileName}",produces={MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public Resource getImage(@PathVariable String fileName) {
        Resource resource=fileService.getImage(fileName);
        return resource;
    }
}
