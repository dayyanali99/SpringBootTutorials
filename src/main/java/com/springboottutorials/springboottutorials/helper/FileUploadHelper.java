package com.springboottutorials.springboottutorials.helper;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.StandardException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

@Component
public class FileUploadHelper
{
//    public final String UPLOAD_DIR = new ClassPathResource("static/img/").getURL().getPath();
    public final String UPLOAD_DIR;

    public FileUploadHelper() throws Exception
    {
        String workingDir = System.getProperty("user.dir")+"/target/classes/static/img/";
        Path path = Paths.get(workingDir);
        Files.createDirectories(path);
        UPLOAD_DIR = new ClassPathResource("static/img/").getURL().getPath();
    }

    public boolean uploadFile(MultipartFile file)
    {
        boolean isUploaded = false;

        try
        {
            // reading file data into data array
//            InputStream inputStream = file.getInputStream();
//            byte[] data = new byte[inputStream.available()];
//            int read = inputStream.read(data);
//
//            // writing data
//            try (FileOutputStream fileOutputStream =
//                         new FileOutputStream(UPLOAD_DIR+"/"+file.getOriginalFilename()))
//            {
//                fileOutputStream.write(data);
//                fileOutputStream.flush();
//                isUploaded=true;
//            }

            // OR

            Path toFile = Paths.get(UPLOAD_DIR+"/"+file.getOriginalFilename());
            Files.copy(file.getInputStream(),toFile,StandardCopyOption.REPLACE_EXISTING);
            isUploaded=true;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return isUploaded;
    }

    public boolean uploadFileDynamic(MultipartFile file)
    {
        boolean isUploaded = false;

        try
        {

//            String userDir = System.getProperty("user.dir")+"/target/classes/static/img";
            // OR
            System.out.println(UPLOAD_DIR);
            Files.copy(file.getInputStream(),
                    Paths.get(UPLOAD_DIR+file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            isUploaded=true;

        } catch (Exception e)
        {
            e.printStackTrace();
        }


        return isUploaded;
    }
}
