package com.example.hospitalrecords.role.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_CREATE("doctor:create"),
    DOCTOR_UPDATE("doctor:update"),
    DOCTOR_DELETE("doctor:delete"),
    RECEPTIONIST_READ("receptionist:read"),
    RECEPTIONIST_CREATE("receptionist:create"),
    RECEPTIONIST_UPDATE("receptionist:update"),
    RECEPTIONIST_DELETE("receptionist:delete"),
    PATIENT_READ("patient:read");

    private final String permission;
}
