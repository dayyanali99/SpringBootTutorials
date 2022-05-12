package com.springboottutorials.springboottutorials.web.rest;

import com.springboottutorials.springboottutorials.helper.FileUploadHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class FileUploadController
{
    private final FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        if (file.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getSize()/1000);
        System.out.println(file.getContentType());

        // File Uploading
        boolean isUploaded = this.fileUploadHelper.uploadFileDynamic(file);
        if (isUploaded)
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/img/")
                    .path(file.getOriginalFilename())
                    .toUriString()); // this code gives image's URI as response body
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
    }

}
