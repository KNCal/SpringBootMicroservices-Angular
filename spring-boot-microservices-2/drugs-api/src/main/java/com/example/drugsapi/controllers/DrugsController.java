package com.example.drugsapi.controllers;

import com.example.drugsapi.models.Drug;
import com.example.drugsapi.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
public class DrugsController {

  //Ask spring to get dependency injection
  @Autowired
  private DrugRepository drugRepository;

  @GetMapping("/")
  public Iterable<Drug> findAllDrug() {
    return drugRepository.findAll();
  }

  //Same name as long as add @PathVariable
  @GetMapping("/{drugId}")
  public Drug findDrugById(@PathVariable Long drugId) {
    return drugRepository.findOne(drugId);
  }

  //Delete a drug by ID
  @DeleteMapping("/{drugId}")
  public HttpStatus deleteDrugById(@PathVariable Long drugId) {
    drugRepository.delete(drugId);
    return HttpStatus.OK;
  }

  //Posting
  @PostMapping("/")
  public Drug createNewDrug(@RequestBody Drug newDrug) {
    return drugRepository.save(newDrug);
  }

  //Naive update
  @PatchMapping("/{drugId}")
  public Drug updateDrugById(@PathVariable Long drugId, @RequestBody Drug drugRequest) {

    Drug drugFromDb = drugRepository.findOne(drugId);

    drugFromDb.setProductcode(drugRequest.getProductcode());
    drugFromDb.setDescription(drugRequest.getDescription());
    drugFromDb.setDistribution(drugRequest.getDistribution());
    drugFromDb.setRecallinitiationdate(drugRequest.getRecallinitiationdate());
    drugFromDb.setRecallingfirm(drugRequest.getRecallingfirm());
    drugFromDb.setStatus(drugRequest.getStatus());

    return drugRepository.save(drugFromDb);
  }

}
