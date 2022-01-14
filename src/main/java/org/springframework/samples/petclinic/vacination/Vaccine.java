package org.springframework.samples.petclinic.vacination;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Vaccine extends BaseEntity {

    @Column(unique=true)
    @Size(min=3,max=50)
    private String name;

    @Column(name = "price")
    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    PetType petType;
}
