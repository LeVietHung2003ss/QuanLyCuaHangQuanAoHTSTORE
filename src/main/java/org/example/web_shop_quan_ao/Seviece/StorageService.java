package org.example.web_shop_quan_ao.Seviece;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service

public interface StorageService {
    void init();
    void store(MultipartFile file);
}

