package com.example.DiplomenProekt.AppControlers;

import com.example.DiplomenProekt.Entity.Admins;
import com.example.DiplomenProekt.Entity.Customers;
import com.example.DiplomenProekt.Entity.Employees;
import com.example.DiplomenProekt.Entity.Role;
import com.example.DiplomenProekt.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collection;

@Controller
public class AppControllerCreate {
    @Autowired
    private AdminsRepository adminsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    ProtocolRepository protocolRepository;
    @GetMapping("/create")
    public  String createPage(){
        return "/Admin/create";
    }

    @GetMapping("/create_customer")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customers());
        return "/Admin/Create/create_customer";
    }
    @PostMapping("/create_customer")
    public String saveCustomer(Customers customers){
        customersRepository.save(customers);
        return "/Admin/Create/create_customer_success";
    }
    @GetMapping("/create_employee")
    public String createEmployee(Model model){
        model.addAttribute("employee", new Employees());
        return "/Admin/Create/create_employee";
    }
    @PostMapping("/create_employee")
    public String saveEmployee(Employees employees){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(employees.getPassword());
        employees.setPassword(encodedPassword);
        Role userRole = roleRepository.findByName("ROLE_EMPLOYEE");
        Collection<Role> userRoles = Arrays.asList(userRole);
        employees.setEmployee_roles(userRoles);
        employeesRepository.save(employees);
        return "/Admin/Create/create_employee_success";
    }
    @GetMapping("/create_admin")
    public String createAdmin(Model model){
        model.addAttribute("admin", new Admins());
        return "/Admin/Create/create_admin";
    }
    @PostMapping("/create_admin")
    public String saveAdmin(Admins admin){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        Collection<Role> userRoles = Arrays.asList(userRole);
        admin.setAdmin_roles(userRoles);
        adminsRepository.save(admin);
        return "/Admin/Create/create_admin_success";
    }
}
