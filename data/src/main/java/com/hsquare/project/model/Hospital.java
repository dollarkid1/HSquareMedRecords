package com.hsquare.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    private Long id;
    private String hospitalName;
    private String website;
    private String email;
    private String address;

}
