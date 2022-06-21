package com.hsquare.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VitalSigns {

    @Id
    private Long id;

    private Long heartRate;

    private Long bloodPressure;

    private Long temperatureRate;

    private String weight;

    private String height;

    private String note;
    @ManyToOne(optional = false)
    private AppUsers appUsers;

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }
}
