package com.example.DiplomenProekt.AppControlers;

import com.example.DiplomenProekt.Entity.Customers;
import com.example.DiplomenProekt.Entity.Employees;
import com.example.DiplomenProekt.Entity.Protocol;
import com.example.DiplomenProekt.Repository.CustomersRepository;
import com.example.DiplomenProekt.Repository.EmployeesRepository;
import com.example.DiplomenProekt.Repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppControllerEmployee {
    @Autowired
    ProtocolRepository protocolRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/protocol")
    public String protocol(Model model, Protocol protocol){
        List<Customers> listcustomer = customersRepository.findAll();
        List<Employees> listEmployee = employeesRepository.findAll();
        model.addAttribute("listCustomer", listcustomer);
        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("customer", new Customers());
        model.addAttribute("employee", new Employees());
        model.addAttribute("protocol",protocol);
        return "/Employee/protocol";
    }
    @PostMapping("/protocol")
    public  String saveProtocol(Protocol protocol){
        protocolRepository.save(protocol);
        return "/Employee/create_protocol_success";
    }
    @GetMapping("employee_option")
    public String employeeOption(){
        return "/Employee/employee_option.html";
    }
}
