package com.example.demo.module.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {
    @Value("${upload.path}")
    private String uploadPath;

    String extension;

    public String uploadImage(MultipartFile uploadFile) {
        if (!Objects.requireNonNull(uploadFile.getContentType()).startsWith("image")) {
            throw new IllegalArgumentException("이미지가 아닙니다.");
        }

        String originalName = uploadFile.getOriginalFilename();

        // 확장자 추출
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf(".") + 1);
        } else {
            throw new IllegalArgumentException("No extension found.");
        }


        String uuid = UUID.randomUUID().toString();

        //String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
        Path savePath = Paths.get(uploadPath + "\\" + uuid+"."+extension);

        try {
            // 원본 파일 저장
            uploadFile.transferTo(savePath);
            return savePath.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("저장 실패");
        }
    }
}
