package com.c1538njavareact.serviLink.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileImageFormatUtil {

    public static boolean isFileImageFormat(MultipartFile imageFile){
        if (!Objects.requireNonNull(imageFile.getContentType()).isEmpty() && imageFile.getContentType().contains("image")){
            return true;
        } else {
            return false;
        }
    }

}
