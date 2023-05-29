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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class  AppControllerUpdate {
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
    @GetMapping("/update")
    public String updatePage(){
        return "/Admin/update";
    }
    @GetMapping("/customer")
    public String customer(Model model){
        List<Customers> listCustomer = customersRepository.findAll();
        model.addAttribute("listCustomer", listCustomer);
        return "/Admin/Update/customer";
    }
    @GetMapping("/customer_update/{id}")
    public String updateCustomer(@PathVariable long id, Model model){
        Customers customer = customersRepository.getById(id);
        model.addAttribute("customer", customer);
        return "/Admin/Update/customer_update";
    }
    @PostMapping("/customer_update/{id}")
    public String update(@PathVariable long id, Customers customers){
        customers.setId(id);
        customersRepository.save(customers);
        return "/Admin/Update/customer";
    }
    @PostMapping("/customer_delete/{id}")
    public String customerDelete(@PathVariable long id) {
        Customers customers = customersRepository.getById(id);
        customersRepository.delete(customers);
        return "/Admin/Update/customer";
    }
    @GetMapping("/admins")
    public String adminUpdate(Model model){
        List<Admins> listAdmin = adminsRepository.findAll();
        model.addAttribute("listAdmins", listAdmin);
        return "/Admin/Update/admins";
    }

    @GetMapping("/admin_update/{id}")
    public String updateAdmin(@PathVariable long id, Model model){
        Admins admin = adminsRepository.getById(id);
        model.addAttribute("admin", admin);
        return "/Admin/Update/admin_update";
    }
    @PostMapping("/admin_update/{id}")
    public String update2(@PathVariable long id, Admins admin){
        admin.setId(id);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        Collection<Role> userRoles = Arrays.asList(userRole);
        admin.setAdmin_roles(userRoles);
        adminsRepository.save(admin);
        return "/Admin/Update/admins";
    }

    @PostMapping("/admin_delete/{id}")
    public String adminDelete(@PathVariable long id) {
        Admins admins = adminsRepository.getById(id);
        adminsRepository.delete(admins);
        return "/Admin/Update/admins";
    }
    @GetMapping("/employees")
    public String employeesUpdate(Model model){
        List<Employees> listEmployees = employeesRepository.findAll();
        model.addAttribute("listEmployees", listEmployees);
        return "/Admin/Update/employees";
    }

    @GetMapping("/employee_update/{id}")
    public String updateEmployee(@PathVariable long id, Model model){
        Employees employee = employeesRepository.getById(id);
        model.addAttribute("employee", employee);
        return "/Admin/Update/employee_update";
    }
    @PostMapping("/employee_update/{id}")
    public String update3(@PathVariable long id, Employees employee){
        employee.setId(id);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        Role userRole = roleRepository.findByName("ROLE_EMPLOYEE");
        Collection<Role> userRoles = Arrays.asList(userRole);
        employee.setEmployee_roles(userRoles);
        employeesRepository.save(employee);
        return "/Admin/Update/employees";
    }

    @PostMapping("/employees_delete/{id}")
    public String employeesDelete(@PathVariable long id) {
        Employees employees = employeesRepository.getById(id);
        employeesRepository.delete(employees);
        return "/Admin/Update/employees";
    }
}
