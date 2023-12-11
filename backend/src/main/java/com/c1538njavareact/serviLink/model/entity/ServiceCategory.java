package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "ServiceCategory")
@Table(name = "services_category")
@Getter
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "services_category_id")
    private Long id;
    private String name;

}
