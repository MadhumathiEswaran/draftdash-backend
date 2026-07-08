package com.example.draftdash.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.draftdash.entity.reviewCycleEntity;
import com.example.draftdash.service.ReviewcycleService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/cycle")
public class reviewcycleController {
    @Autowired
    ReviewcycleService Aser;
    @PostMapping("/post")
    public reviewCycleEntity saveData(@Valid @RequestBody  reviewCycleEntity data)
    {
        return Aser.saveData(data);
    }
    /*@GetMapping("/review/data")
    public String review(){
        return "Welcome to Review Cycle Module";
    }*/
    @GetMapping("/get")
    public List< reviewCycleEntity> getData(){
        return Aser.getAllData();
    }
    @GetMapping("/get/{id}")
    public reviewCycleEntity  getUserData(@PathVariable Long id)
    {
            return Aser.getUserDetails(id);
           
    }
    @PutMapping("/put/{id}")
    public  reviewCycleEntity updateData (@PathVariable Long id,@RequestBody  reviewCycleEntity data)
    {
        return Aser.updateDatabase(id,data);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id)
    {
      try{
             reviewCycleEntity getData=Aser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }  
    catch(Exception e)
    {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
@PatchMapping("/patch/{id}")
public  reviewCycleEntity patchData(@PathVariable Long id,@RequestBody  reviewCycleEntity data) {

    return Aser.patchDatabase(id, data);
}

}

