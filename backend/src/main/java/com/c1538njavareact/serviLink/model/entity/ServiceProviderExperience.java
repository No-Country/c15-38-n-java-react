package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ServiceProviderExperience")
@Table(name = "service_provider_experience")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
