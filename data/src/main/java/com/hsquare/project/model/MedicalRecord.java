package com.hsquare.project.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    @Id
    private Long id;

    private String note;

    private String diagnosis;

    private String prescription;

    @ManyToOne(optional = false)
    private AppUsers appUsers;

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }
}
