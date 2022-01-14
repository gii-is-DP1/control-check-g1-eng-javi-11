package org.springframework.samples.petclinic.vacination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VaccinationService {

    private VaccinationRepository vaccinationRepository;

    @Autowired
    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    @Transactional
    public List<Vaccination> getAll(){
        return vaccinationRepository.findAll();
    }
    @Transactional
    public List<Vaccine> getAllVaccines(){
        return null;
    }
    @Transactional
    public Vaccine getVaccine(String typeName) {
        return vaccinationRepository.findByName(typeName);
    }
    @Transactional(rollbackFor = UnfeasibleVaccinationException.class)

    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {
        Pet a=p.getVaccinatedPet();
        //tipo de la mascota
        PetType type=a.getType();
        if(!type.equals(p.getVaccine().getPetType())){
            throw new UnfeasibleVaccinationException();
        }
        else{
            vaccinationRepository.save(p);
        }

        return vaccinationRepository.save(p);
    }

    
}
