package com.example.Shelter.Сontrollers;

import com.example.Shelter.models.Owner;
import com.example.Shelter.repos.DogRepository;
import com.example.Shelter.repos.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OwnersController {
    @Autowired
    private OwnerRepository ownerRepository;
    private DogRepository dogRepository;

    @GetMapping("/wantDog")
    public String wantDog(Model model){
        return "wantDog";
    }

    @PostMapping("/wantDog")
    public String ownerDog(@RequestParam String userName, @RequestParam String dogName, @RequestParam String phone, @RequestParam String email, @RequestParam String goal, @RequestParam String answers, @RequestParam String control, Model model){
        Owner owner = new Owner(userName, dogName, phone, email, goal, answers, control);
        ownerRepository.save(owner);
        return "redirect:/dogList";
    }
    @GetMapping("/ownerList")
    public String ownerList(Model model){
        Iterable<Owner> owner = ownerRepository.findAll();
        model.addAttribute("owner", owner);
        return "ownRequest";
    }
}
