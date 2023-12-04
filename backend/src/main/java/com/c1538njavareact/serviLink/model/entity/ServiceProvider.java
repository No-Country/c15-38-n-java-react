package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "ServiceProvider")
@Table(name = "services_provider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "services_provider_id")
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "providers_id", nullable = false)
    private  Provider providers;
    @ManyToOne
    @JoinColumn(name = "services_id", nullable = false)
    private Service services;
    @OneToMany(mappedBy = "servicesProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ServiceProviderExperience> serviceProviderExperienceList;

}
