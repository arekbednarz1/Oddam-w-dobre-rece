package pl.arekbednarz.oddam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arekbednarz.oddam.entity.Category;
import pl.arekbednarz.oddam.entity.Donation;
import pl.arekbednarz.oddam.entity.Institution;
import pl.arekbednarz.oddam.repository.CategoryRepository;
import pl.arekbednarz.oddam.repository.DonationRepository;
import pl.arekbednarz.oddam.repository.InstitutionRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InstitutionRepository institutionRepository;


    @Autowired
    private DonationRepository donationRepository;


    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findFirstById(categoryId);
    }

   public Donation getCurrentDonation(HttpSession session) {
        return (Donation) session.getAttribute("donationInSession");
    }

   public void setCategories(Long[] categoriesChecked, Donation donationInSession) {
        List<Category> categories = new ArrayList<>();
        for (Long categoryId : categoriesChecked) {
            Category category = getCategoryById(categoryId);
            categories.add(category);
        }
        donationInSession.setCategories(categories);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }


    public Institution getByName(String institution){
        return institutionRepository.getByName(institution);
    }


    public void save(Donation donation) {
        donationRepository.save(donation);
    }
}
