package com.hsquare.project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String dob;

    @Column(nullable = false)
    private String phoneNumber;

    private String email;

    @Column(nullable = false)
    private String password;

    private Gender gender;

    private String maritalStatus;

    private String religion;

    private String occupation;

    @OneToMany(mappedBy = "users")
    @JoinColumn(name = "records_id")
    private List<Record> records;


    @OneToMany(mappedBy = "users")
    @JoinColumn(name = "vital_signs_id")
    private List<VitalSigns> vitalSigns;

    @CreationTimestamp
    private LocalDateTime dateCreated;




}





