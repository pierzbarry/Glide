package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listFlights(Model model) {
        model.addAttribute("flights", flightRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String flightForm(Model model) {
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute Flight flight, @RequestParam("file") MultipartFile file, @RequestParam("imageurl") String imageurl) {
        if (!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype" , "auto"));
                flight.setImageurl(uploadResult.get("url").toString());

            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(file.isEmpty() && imageurl.equalsIgnoreCase("")){
            flight.setImageurl(null);
        }
        flightRepository.save(flight);
        return "redirect:/";

    }

    @RequestMapping("/detail/{id}")
    public String showFlight(@PathVariable("id") long id, Model model) {
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "showflight";
    }

    @RequestMapping("/update/{id}")
    public String updateFlight(@PathVariable("id") long id, Model model) {
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "flightform";
    }

    @RequestMapping("/delete/{id}")
    public String delFlight(@PathVariable("id") long id) {
        flightRepository.deleteById(id);
        return "redirect:/";
    }
}
