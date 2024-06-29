package diabetes.med.diabetesTracker;


import diabetes.med.diabetesTracker.model.Glycemie;
import diabetes.med.diabetesTracker.service.GlycemieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glycemie")
public class GlycemieRessource {
    private final GlycemieService glycemieService;

    public GlycemieRessource(GlycemieService glycemieService) {
        this.glycemieService = glycemieService;
    }
    @GetMapping("/all")
    public ResponseEntity <List<Glycemie>> getAllGlycemie (){
        List <Glycemie> glycemies = glycemieService.findAllGlycemie();
        return new ResponseEntity<>(glycemies , HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity <Glycemie> getGlycemieById (@PathVariable("id")Long id){
        Glycemie glycemie = glycemieService.findGlycemieById(id);
        return new ResponseEntity<>(glycemie , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity <Glycemie> addGlycemie(@RequestBody Glycemie glycemie){
        Glycemie newglycemie = glycemieService.addGlycemie(glycemie);
        return new ResponseEntity<>(newglycemie , HttpStatus. CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity <Glycemie> updateGlycemie(@RequestBody Glycemie glycemie){
        Glycemie updateGlycemie = glycemieService.updateGlycemie(glycemie);
        return new ResponseEntity<>(updateGlycemie , HttpStatus. OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> deleteGlycemie(@PathVariable("id")Long id){
        glycemieService.deleteGlycemie(id);
        return new ResponseEntity<>(HttpStatus. OK);
    }




}
