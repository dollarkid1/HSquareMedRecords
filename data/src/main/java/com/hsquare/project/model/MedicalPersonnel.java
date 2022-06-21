package com.hsquare.project.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class MedicalPersonnel {
    @Enumerated(EnumType.STRING)
    PractitionerType personnel;

}
