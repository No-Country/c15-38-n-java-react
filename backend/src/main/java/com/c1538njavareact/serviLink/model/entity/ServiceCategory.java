package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ServiceCategory")
@Table(name = "services_category")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "services_category_id")
    private Long id;
    private String name;

}
