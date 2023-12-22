package com.c1538njavareact.serviLink.utils;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import java.util.Objects;

public class MethodsUtil {

    public static boolean isFileImageFormat(MultipartFile imageFile){
        if (!Objects.requireNonNull(imageFile.getContentType()).isEmpty() && imageFile.getContentType().contains("image")){
            return true;
        } else {
            return false;
        }
    }

    public static void existsById(Long id, JpaRepository repository, String object){
        if (repository.existsById(id)){
        } else {
            throw new IntegrityValidation("Does not exists any " + object + " with ID " + id);
        }
    }

}
