package com.hsquare.project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String dob;

    private String phoneNumber;

    private String email;

    @Column(nullable = false)
    private String password;

    private Gender gender;

    private String maritalStatus;

    private String religion;

    private String occupation;

    @CreationTimestamp
    private LocalDateTime dateCreated;



}
