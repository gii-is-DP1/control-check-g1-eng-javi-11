package org.springframework.samples.petclinic.vacination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vaccination")
public class VaccinationController {


    private final VaccinationService vaccinationService;
    private final PetService petService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService, PetService petService) {
        this.vaccinationService = vaccinationService;
        this.petService = petService;
    }


    @GetMapping(value = "/create")
    public String initCreationForm(ModelMap model) {
        Vaccination vaccination= new Vaccination();
        Vaccine vaccine=new Vaccine();
        List<Vaccine> vaccines=vaccinationService.getAllVaccines();
        List<Pet> pets=new ArrayList<>(petService.findAllPets());

        model.put("vaccination", vaccination);
        model.put("vaccines",vaccines);
        model.put("vaccine",vaccine);
        model.put("pets",pets);
        return "vaccination/createOrUpdateVaccinationForm";

    }
    @PostMapping(value="/update")
    public ModelAndView proccessCreationForm(BindingResult result, @Valid Vaccination vaccination) throws UnfeasibleVaccinationException {

        if(result.hasErrors()) {
            ModelAndView mav=new ModelAndView("/vaccination/createOrUpdateVaccinationForm");
            mav.addObject("vaccination",vaccination);
            return mav;
        } else {
            ModelAndView mav=new ModelAndView("/welcome");
            vaccinationService.save(vaccination);
            return mav;
        }
    }
    
}
