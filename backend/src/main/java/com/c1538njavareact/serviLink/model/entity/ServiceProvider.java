package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private  Provider provider;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
    @OneToMany(mappedBy = "servicesProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ServiceProviderExperience> serviceProviderExperienceList;

    public ServiceProvider(Provider provider, Service service, String description, BigDecimal price){
        this.provider = provider;
        this.service = service;
        this.description = description;
        this.price = price;
    }
}
