package org.example.web_shop_quan_ao.Controller.Admin;

import org.example.web_shop_quan_ao.Seviece.SystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/upload")
public class TestUploadFile {
    @Autowired
    public SystemStorageService systemStorageService;
    @GetMapping
    public String uploadDemo(){
        return "index";
    }
    @PostMapping
    public String save(@RequestParam("file")MultipartFile file){
        systemStorageService.store(file);
        return "index";
    }
}
