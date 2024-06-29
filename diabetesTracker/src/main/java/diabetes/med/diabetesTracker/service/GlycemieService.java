package diabetes.med.diabetesTracker.service;

import diabetes.med.diabetesTracker.service.execption.GlycemieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import diabetes.med.diabetesTracker.model.Glycemie;
import diabetes.med.diabetesTracker.rep.GlycemieRepo;


import java.util.List;

@Service
public class GlycemieService {

    private final GlycemieRepo glycemieRepo;

    @Autowired
    public GlycemieService(GlycemieRepo glycemieRepo) {
        this.glycemieRepo = glycemieRepo;
    }

    public Glycemie addGlycemie(Glycemie glycemie) {
        return glycemieRepo.save(glycemie);
    }

    public List<Glycemie> findAllGlycemie() {
        return glycemieRepo.findAll();
    }

    public Glycemie updateGlycemie(Glycemie glycemie) {
        return glycemieRepo.save(glycemie);
    }

    public Glycemie findGlycemieById(Long id) {
        return glycemieRepo.findGlycemieById(id)
                .orElseThrow(() -> new GlycemieNotFoundException("Glycemie with id " + id + " not found"));
    }

    public void deleteGlycemie(Long id) {
        glycemieRepo.deleteGlycemieById(id);
    }
}
