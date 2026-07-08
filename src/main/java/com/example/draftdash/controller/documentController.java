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

import com.example.draftdash.entity.documentEntity;
import com.example.draftdash.service.DocumentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/doc")
public class documentController {
    @Autowired
    DocumentService Aser;
    @PostMapping("/post")
    public documentEntity saveData(@Valid @RequestBody documentEntity data)
    {
        return Aser.saveData(data);
    }
   /*  @GetMapping("document/data")
    public String document(){
        return "Welcome to Document Module";
    }*/
    @GetMapping("/get")
public List<documentEntity> getData(){
    return Aser.getAllData();
}
    @GetMapping("/get/{id}")
    public documentEntity getUserData(@PathVariable Long id)
    {
        return Aser.getUserDetails(id);
    }
    @PutMapping("/put/{id}")
    public documentEntity updateData (@PathVariable Long id,@RequestBody documentEntity data)
    {
        return Aser.updateDatabase(id,data);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id)
    {
      try{
            documentEntity getData=Aser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }  
    catch(Exception e)
    {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
@PatchMapping("/patch/{id}")
public documentEntity patchData(@PathVariable Long id,@RequestBody documentEntity data) {

    return Aser.patchDatabase(id, data);
}

}
