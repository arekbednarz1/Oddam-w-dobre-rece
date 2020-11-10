package pl.arekbednarz.oddam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.oddam.entity.Institution;
import pl.arekbednarz.oddam.service.HomeService;

import java.util.List;


@Controller
public class HomeController {

    private HomeService homeService;


    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }



    @ModelAttribute("institutions")
    List<Institution> institutionList() {
        System.out.println(homeService.getAllInstitutions());
        return homeService.getAllInstitutions();
    }
    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }


}
