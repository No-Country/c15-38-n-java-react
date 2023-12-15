package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ServiceProviderExperience")
@Table(name = "service_provider_experience")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceProviderExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_provider_experience_id")
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "alt_text")
    private String altText;
    @Column(name = "experience_description")
    private String experienceDescription;
    @ManyToOne
    @JoinColumn(name = "services_provider_id", nullable = false)
    private ServiceProvider servicesProvider;


    public ServiceProviderExperience
            (String imageUrl, String altText, String experienceDescription, ServiceProvider serviceProvider) {
        this.imageUrl = imageUrl;
        this.altText = altText;
        this.experienceDescription = experienceDescription;
        this.servicesProvider = serviceProvider;
    }
}
