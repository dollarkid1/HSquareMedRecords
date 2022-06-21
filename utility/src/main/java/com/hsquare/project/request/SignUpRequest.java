package com.hsquare.project.request;

import com.hsquare.project.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {
    private String phoneNumber;
    private String email;
    private String password;
    private Set<String> roles;
}
