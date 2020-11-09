package pl.arekbednarz.oddam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddam.entity.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
