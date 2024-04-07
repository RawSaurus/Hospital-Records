package com.example.hospitalrecords.role;

import com.example.hospitalrecords.role.model.Role;
import com.example.hospitalrecords.role.model.RoleType;
import com.example.hospitalrecords.role.repository.RoleRepository;
import jakarta.persistence.OneToOne;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private  final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       this.loadRoles();
    }

    private void loadRoles(){
        RoleType[] roleNames = new RoleType[] {
                RoleType.PATIENT,
                RoleType.DOCTOR,
                RoleType.RECEPTIONIST,
                RoleType.ADMIN
        };
        Map<RoleType, String> roleDescriptionMap = Map.of(
                RoleType.PATIENT, "Patient role",
                RoleType.DOCTOR, "Doctor role",
                RoleType.RECEPTIONIST, "Receptionist role",
                RoleType.ADMIN, "Admin role"
        );

        Arrays.stream(roleNames).forEach(roleType -> {
            Optional<Role> optionalRole = roleRepository.findByName(roleType);

            optionalRole.ifPresentOrElse(System.out::println, () ->{
                Role roleToCreate = new Role();

                roleToCreate.setName(roleType);
                roleToCreate.setDescription(roleDescriptionMap.get(roleType));

                roleRepository.save(roleToCreate);
            });
        });
    }
}
