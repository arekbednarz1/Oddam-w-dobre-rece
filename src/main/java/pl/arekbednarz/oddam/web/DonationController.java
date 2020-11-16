package pl.arekbednarz.oddam.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.oddam.entity.Category;
import pl.arekbednarz.oddam.entity.Donation;
import pl.arekbednarz.oddam.entity.Institution;
import pl.arekbednarz.oddam.service.DonationService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/donation")
@SessionAttributes({"donationInSession"})
public class DonationController {
    private final DonationService donationService;

    @Autowired
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }



    @ModelAttribute("donation")
    public Donation donationForm() {
        return new Donation();
    }

    @ModelAttribute("institutions")
    public List<Institution> addInstitutions() {
        return donationService.getAllInstitutions();
    }

    @ModelAttribute("categories")
    public List<Category> addCategories() {
        return donationService.getAllCategories();
    }


    @GetMapping
    public String addDonation() {
        return "donation/donationAdd";
    }

    @PostMapping
    String donateFormAction(@Valid @ModelAttribute("donation") Donation donation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "donation/donationAdd";
        donationService.save(donation);
        return "donation/donationConfirm";
    }


}