package com.c1538njavareact.serviLink.utils;

import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

public interface IUploadImage {

    Map uploadImage(MultipartFile imageFile, String path);

}
