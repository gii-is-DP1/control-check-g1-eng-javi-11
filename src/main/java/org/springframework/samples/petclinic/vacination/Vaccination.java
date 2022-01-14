package org.springframework.samples.petclinic.vacination;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Vaccination")
public class Vaccination extends BaseEntity {

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vaccinated_pet_id")
    private Pet vaccinatedPet;



    @ManyToOne
    Vaccine vaccine; 
}
