package pl.arekbednarz.oddam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arekbednarz.oddam.entity.Institution;
import pl.arekbednarz.oddam.repository.DonationRepository;
import pl.arekbednarz.oddam.repository.InstitutionRepository;

import java.util.List;

@Service
public class HomeService {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    @Autowired
    public HomeService(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

   public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

}
