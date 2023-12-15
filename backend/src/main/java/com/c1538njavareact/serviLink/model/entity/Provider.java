package com.c1538njavareact.serviLink.model.entity;

import com.c1538njavareact.serviLink.model.dto.ProviderDataUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Provider")
@Table(name = "providers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    @Column(name = "cloudinary_public_id")
    private String cloudinaryPublicId;
    @Column(nullable = false)
    private boolean isActive = true;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceProvider> serviceProviderList;

    @OneToOne(orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Provider(String firstName, String email, User user) {
        this.firstName = firstName;
        this.email = email;
        this.user = user;
    }

    public void updateData(ProviderDataUpdate providerDataUpdate) {
        if (providerDataUpdate.firstName() != null) {
            this.firstName = providerDataUpdate.firstName();
        }
        if (providerDataUpdate.lastName() != null) {
            this.lastName = providerDataUpdate.lastName();
        }
        if (providerDataUpdate.phoneNumber() != null) {
            this.phoneNumber = providerDataUpdate.phoneNumber();
        }
    }

    public void deactivateProvider() {
        this.isActive = false;
    }
}
