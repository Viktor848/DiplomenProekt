package com.example.DiplomenProekt.AppControlers;

import com.example.DiplomenProekt.Entity.Protocol;
import com.example.DiplomenProekt.Repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppControllerAdmin {
    @Autowired
    ProtocolRepository protocolRepository;

    @GetMapping("/admin_option")
    public String adminOption(){
        return "/Admin/admin_option";
    }

    @GetMapping("/statics")
    public String statics(Model model){
        List<Protocol> listUsers = protocolRepository.findAll();
        model.addAttribute("listProtocol", listUsers);
        return "/Admin/statics";
    }
}
