package com.hsquare.project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
//       })
public class AppUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    private String dob;

    @Column(nullable = false)
    @NotBlank
    private String phoneNumber;

    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String maritalStatus;

    private String religion;

    private String occupation;

//    @JoinTable(name = "user_roles",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id"))
    //@OneToMany
    @ManyToMany
    private Set<Role> roles;

    @OneToMany//(mappedBy = "appUsers")
//    @JoinColumn(name = "records_id")
    private List<MedicalRecord> medicalRecords;


    @OneToMany//(mappedBy = "appUsers")
//    @JoinColumn(name = "vital_signs_id")
    private List<VitalSigns> vitalSigns;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    public AppUsers(String firstName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


}





