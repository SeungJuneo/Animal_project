package com.example.demo.module.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

@RequiredArgsConstructor
@RestController
public class FileController {
    private final FileService fileService;
    private final ResourceLoader resourceLoader;

    @Value("${upload.path}")
    private String uploadDir;

    @PostMapping("/api/member/uploadAjax")
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
        try {
            String imagePath =  fileService.uploadImage(uploadFile);
            imagePath = imagePath.substring("src/main/resources/static/".length());
            return ResponseEntity.ok(imagePath);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/images/{filename}")
    public Resource showImage(@PathVariable("filename") String filename) throws MalformedURLException {
        return resourceLoader.getResource("file:" + uploadDir + "/" + filename);
    }
}

