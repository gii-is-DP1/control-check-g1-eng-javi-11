package org.springframework.samples.petclinic.vacination;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class VaccineFormatter implements Formatter<Vaccine>{

    private final VaccinationRepository vaccinationRepository;

    @Autowired
    public VaccineFormatter(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    @Override
    public String print(Vaccine object, Locale locale) {
       return object.getName();
    }

    @Override
    public Vaccine parse(String text, Locale locale) throws ParseException {
        Collection<Vaccine> findVaccineTypes= vaccinationRepository.findAllVaccines();
        for(Vaccine v:findVaccineTypes){
            if(v.getName().equals(text)){
                return v;
            }
        }
        throw new ParseException("Vaccine not found: "+text,0);
    }
    
}
