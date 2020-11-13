package pl.arekbednarz.oddam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddam.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findFirstById(Long categoryId);

}
