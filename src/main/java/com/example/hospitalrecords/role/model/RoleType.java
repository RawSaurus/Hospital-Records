package com.example.hospitalrecords.role.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.hospitalrecords.role.model.Permission.*;

@Getter
@RequiredArgsConstructor
public enum RoleType { //TODO create database implementation for roles and permissions
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    DOCTOR_READ,
                    DOCTOR_CREATE,
                    DOCTOR_UPDATE,
                    DOCTOR_DELETE,
                    RECEPTIONIST_READ,
                    RECEPTIONIST_CREATE,
                    RECEPTIONIST_UPDATE,
                    RECEPTIONIST_DELETE
            )
    ),
    DOCTOR(
            Set.of(

                    DOCTOR_READ,
                    DOCTOR_CREATE,
                    DOCTOR_UPDATE,
                    DOCTOR_DELETE
            )
    ),
    RECEPTIONIST(
            Set.of(
                    RECEPTIONIST_READ,
                    RECEPTIONIST_CREATE,
                    RECEPTIONIST_UPDATE,
                    RECEPTIONIST_DELETE
            )
    ),
    PATIENT(Collections.emptySet());


    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
