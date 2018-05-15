package com.example.drugsapi.repositories;

import com.example.drugsapi.models.Drug;
import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<Drug, Long> {

}


