package pl.arekbednarz.oddam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.oddam.entity.Category;
import pl.arekbednarz.oddam.entity.Donation;
import pl.arekbednarz.oddam.service.DonationService;

import javax.servlet.http.HttpSession;
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

    @ModelAttribute("categories")
    List<Category> populateCategories() {
        return donationService.getAllCategories();
    }


    @GetMapping(value = "/add-step-1")
    public String donationAddFormStep1Show(Model model, HttpSession session) {
        Donation donationInSession = donationService.getCurrentDonation(session);
        if (donationInSession == null) {
            donationInSession = new Donation();
        }
        model.addAttribute("donationInSession", donationInSession);
        return "donationAdd1";
    }

    @PostMapping(value = "/add-step-1")
    public String donationAddFormStep1Process(@RequestParam(value = "category", required = false) Long[] categoriesChecked, HttpSession session, Model model) {
        if(categoriesChecked == null || categoriesChecked.length == 0) {
            model.addAttribute("errorNothingChecked", "wybierz kategorię");
            return "donationAdd1";
        }
        Donation donationInSession = donationService.getCurrentDonation(session);
        donationService.setCategories(categoriesChecked, donationInSession);
        model.addAttribute("donationInSession", donationInSession);
        return "redirect:add-step-2";
    }

    }



