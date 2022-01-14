/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.pet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.vacination.Vaccine;

import java.util.List;

/**
 * @author Juergen Hoeller Can be Cat, Dog, Hamster...
 */
@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

    @OneToMany(cascade= CascadeType.ALL,mappedBy = "petType")
    public List<Vaccine> vaccineList;

}
