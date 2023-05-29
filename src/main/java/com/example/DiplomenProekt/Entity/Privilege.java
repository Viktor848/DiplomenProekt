package com.example.DiplomenProekt.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "adminPrivileges")
    private Collection<Role> adminRoles;

    @ManyToMany(mappedBy = "employeePrivileges")
    private Collection<Role> employeeRoles;


    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(Collection<Role> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public Collection<Role> getEmployeeRoles() {
        return employeeRoles;
    }

    public void setEmployeeRoles(Collection<Role> employeeRoles) {
        this.employeeRoles = employeeRoles;
    }

}
