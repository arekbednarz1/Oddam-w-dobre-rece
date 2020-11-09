package pl.arekbednarz.oddam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddam.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
