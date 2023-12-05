package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "Service")
@Table(name = "services")
@Getter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "services_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "services_category_id", nullable = false)
    private ServiceCategory serviceCategory;


}