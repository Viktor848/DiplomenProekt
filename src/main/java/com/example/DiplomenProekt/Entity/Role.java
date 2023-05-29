package com.example.DiplomenProekt.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "admin_roles")
    private Collection<Admins> users;

    @ManyToMany(mappedBy = "employee_roles")
    private Collection<Employees> employees;

    @ManyToMany
    @JoinTable(
            name = "admin_roles_privileges",
            joinColumns = @JoinColumn(
                    name = "admin_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "admin_privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> adminPrivileges;

    @ManyToMany
    @JoinTable(
            name = "employee_roles_privileges",
            joinColumns = @JoinColumn(
                    name = "employee_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "employee_privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> employeePrivileges;

    public Collection<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employees> employees) {
        this.employees = employees;
    }

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

    public Collection<Admins> getUsers() {
        return users;
    }

    public void setUsers(Collection<Admins> users) {
        this.users = users;
    }

    public Collection<Employees> getEmployee() {
        return employees;
    }

    public void setEmployee(Collection<Employees> employees) {
        this.employees = employees;
    }

    public Collection<Privilege> getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(Collection<Privilege> adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

    public Collection<Privilege> getEmployeePrivileges() {
        return employeePrivileges;
    }

    public void setEmployeePrivileges(Collection<Privilege> employeePrivileges) {
        this.employeePrivileges = employeePrivileges;
    }
}
