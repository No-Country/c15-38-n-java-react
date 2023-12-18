package com.c1538njavareact.serviLink.service.impl;

import com.c1538njavareact.serviLink.exception.IntegrityValidation;
import com.c1538njavareact.serviLink.model.dto.ProviderDataGetOne;
import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import com.c1538njavareact.serviLink.model.entity.Provider;
import com.c1538njavareact.serviLink.repository.IProviderRepository;
import com.c1538njavareact.serviLink.service.IProviderService;
import com.c1538njavareact.serviLink.utils.IUploadImage;
import com.c1538njavareact.serviLink.utils.MethodsUtil;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderService implements IProviderService, IUploadImage {
    @Autowired
    private IProviderRepository iProviderRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<ProviderDataGetOne> getByUserId(Long id) {
        Provider provider = iProviderRepository.findByUserId(id);
        ProviderDataGetOne providerDataGetOne = new ProviderDataGetOne(provider.getFirstName(), provider.getLastName(),
                provider.getEmail(), provider.getPhoneNumber(), provider.getProfileImageUrl());
        return ResponseEntity.ok(providerDataGetOne);
    }

    @Transactional
    @Override
    public ResponseEntity<ProviderDataGetOne> updateProvider(Long id, ProviderDataUpdate providerDataUpdate, MultipartFile imageFile) throws IOException {

        Provider provider = iProviderRepository.getReferenceByUserId(id);

        if(imageFile != null) {
            if (MethodsUtil.isFileImageFormat(imageFile)){
                if(provider.getProfileImageUrl() != null){
                    cloudinary.uploader().destroy(provider.getCloudinaryPublicId(), Map.of());
                }
                Map imageUploaded = new HashMap(uploadImage(imageFile, "servilink/provider/"));
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

    @Transactional
    @Override
    public ResponseEntity deactivateProvider(Long id) {
        Provider provider = iProviderRepository.getReferenceByUserId(id);
        provider.deactivateProvider();
        return ResponseEntity.noContent().build();
    }

    @Override
    public Map uploadImage(MultipartFile imageFile, String path) {
        try {
            return this.cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.asMap(
                    "folder", path));
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed!");
        }
    }

}
