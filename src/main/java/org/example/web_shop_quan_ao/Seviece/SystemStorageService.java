package org.example.web_shop_quan_ao.Seviece;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class SystemStorageService implements StorageService {
    private final Path rootLocation;
    public  SystemStorageService(){
        rootLocation=Paths.get("src/main/resources/static/assets/img/products");
    }
    @Override
    public void init() {
        try{
            Files.createDirectories(rootLocation);
        }catch (Exception e){

        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try(InputStream inputStream=file.getInputStream()){
                Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (IOException e){
                e.printStackTrace();
            }

    }
}