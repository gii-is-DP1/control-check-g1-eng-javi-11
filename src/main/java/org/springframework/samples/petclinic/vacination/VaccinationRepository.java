package org.springframework.samples.petclinic.vacination;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VaccinationRepository extends CrudRepository<Vaccination,Integer> {
    List<Vaccination> findAll();

    @Query("SELECT DISTINCT vc FROM Vaccine vc")
    List<Vaccine> findAllVaccines();


    @Query("Select DISTINCT vc FROM Vaccine vc WHERE vc.name=:name")
    Vaccine findByName(String name);


    Optional<Vaccination> findById(int id);

    Vaccination save(Vaccination p);
}
