package com.futao.springbootservice.controller.file;

import com.futao.springbootservice.utils.AppUtil;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 文件
 *
 * @author futao
 * @date 2020/12/1
 */
@Slf4j
@RequestMapping("/file")
@RestController
@SkipUserAuth
public class FileController {

    @Value("${app.file.upload.path}")
    private String fileUploadPath;

    /**
     * 文件上传
     *
     * @param files
     * @param extParam
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String[] upload(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("extParam") String extParam) throws IOException {
        String[] fileUrls = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String originalFilename = file.getOriginalFilename();
            String fileExtNameWithPoint = AppUtil.getFileExtNameWithPoint(originalFilename);
            String uuid = AppUtil.uuid();
            String finalFileName = uuid + fileExtNameWithPoint;
            Files.copy(file.getInputStream(), Paths.get(fileUploadPath + finalFileName));
            fileUrls[i] = finalFileName;
        }
        return fileUrls;
    }
}
