package diabetes.med.diabetesTracker.rep;

import diabetes.med.diabetesTracker.model.Glycemie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlycemieRepo extends JpaRepository<Glycemie, Long> {
    List<Glycemie> findByNameContainingIgnoreCase(String name);

}