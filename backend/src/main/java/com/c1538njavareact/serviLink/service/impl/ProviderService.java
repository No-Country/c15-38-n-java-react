package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.repository.IProviderRepository;
import com.c1538njavareact.serviLink.service.IProviderService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ProviderService implements IProviderService {
    @Autowired
    private IProviderRepository iProviderRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public ResponseEntity<ProviderDataGetOne> getByUserId(Long id) {
        Provider provider = iProviderRepository.findByUserId(id);
        ProviderDataGetOne providerDataGetOne = new ProviderDataGetOne(provider.getFirstName(), provider.getLastName(),
                provider.getEmail(), provider.getPhoneNumber(), provider.getProfileImageUrl());
        return ResponseEntity.ok(providerDataGetOne);
    }

    @Override
    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate, MultipartFile imageFile) throws IOException {

        Provider provider = iProviderRepository.getReferenceByUserId(id);

        if(imageFile != null) {
            if (isFileImageFormat(imageFile)){
                if(provider.getProfileImageUrl() != null){
                    cloudinary.uploader().destroy(provider.getCloudinaryPublicId(), Map.of());
                }
                Map imageUploaded = new HashMap(uploadImage(imageFile));
                provider.setProfileImageUrl(imageUploaded.get("secure_url").toString());
                provider.setCloudinaryPublicId(imageUploaded.get("public_id").toString());
            } else {
                throw new IntegrityValidation("Only accept image files!");
            }
        }

        provider.updateData(providerDataUpdate);

        return ResponseEntity.ok(new ProviderDataGetOne(provider.getFirstName(), provider.getLastName(),
                provider.getEmail(), provider.getPhoneNumber(), provider.getProfileImageUrl()));
    }

    @Override
    public ResponseEntity deactivateProvider(Long id) {
        Provider provider = iProviderRepository.getReferenceByUserId(id);
        provider.deactivateProvider();
        return ResponseEntity.noContent().build();
    }

    private boolean isFileImageFormat(MultipartFile imageFile){
        if (!Objects.requireNonNull(imageFile.getContentType()).isEmpty() && imageFile.getContentType().contains("image")){
            return true;
        } else {
            return false;
        }
    }

    private Map uploadImage(MultipartFile imageFile) {
        try {
            return this.cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.asMap(
                    "folder", "servilink/provider/"));
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed!");
        }
    }

}
