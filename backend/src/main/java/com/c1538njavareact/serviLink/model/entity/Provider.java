package com.c1538njavareact.serviLink.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "Provider")
@Table(name = "providers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "providers_id", unique = true)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    @OneToMany(mappedBy = "providers", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceProvider> serviceProviderList;

}
