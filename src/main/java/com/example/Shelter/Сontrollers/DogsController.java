package com.example.Shelter.Сontrollers;

import com.example.Shelter.models.Dog;
import com.example.Shelter.repos.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DogsController {
    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/dogList")
    public String dogsList(Model model){
        Iterable<Dog> dogs = dogRepository.findAll();
        model.addAttribute("dogs", dogs);
        return "dogList";
    }

    @GetMapping("/dogAdd")
    public String dogAdd(Model model){
        return "dogAdd";
    }

    @PostMapping("/dogAdd")
    public String dogPost(@RequestParam String name, @RequestParam String gender, @RequestParam String discr, @RequestParam String url, @RequestParam("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob, Model model){
        Dog dog = new Dog(name, gender, discr, url, dob);
        dogRepository.save(dog);
        return "redirect:/dogList";
    }

    @GetMapping("/dogList/{id}")
    public String dogInfo(@PathVariable(value = "id") long id, Model model){
        if (!dogRepository.existsById(id)) {
            return "redirect:/dogList";
        }
        Optional<Dog> dog = dogRepository.findById(id);
        ArrayList<Dog> res = new ArrayList<>();
        dog.ifPresent(res::add);
        model.addAttribute("dog", res);
        return "dogInfo";
    }

    @GetMapping("/dogList/{id}/edit")
    public String dogRedact(@PathVariable(value = "id") long id, Model model){
        if (!dogRepository.existsById(id)) {
            return "redirect:/dogList";
        }
        Optional<Dog> dog = dogRepository.findById(id);
        ArrayList<Dog> res = new ArrayList<>();
        dog.ifPresent(res::add);
        model.addAttribute("dog", res);
        return "dogRedact";
    }

    @PostMapping("/dogList/{id}/edit")
    public String dogUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String gender, @RequestParam String discr, @RequestParam String url, @RequestParam("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob, Model model){
        Dog dog = dogRepository.findById(id).orElseThrow();
        dog.setName(name);
        dog.setGender(gender);
        dog.setDiscr(discr);
        dog.setDob(dob);
        dogRepository.save(dog);
        return "redirect:/dogList";
    }
}
