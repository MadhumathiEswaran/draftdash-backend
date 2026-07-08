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

import com.example.draftdash.entity.documentVersionEntity;
import com.example.draftdash.service.DocumentversionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/version")
public class documentversionController {
    @Autowired
    DocumentversionService Aser;
    @PostMapping("/post")
    public documentVersionEntity saveData(@Valid @RequestBody documentVersionEntity data)
    {
        return Aser.saveData(data);
    }
   /*  @GetMapping("/version/data")
    public String version(){
        return "Welcome to Document Version Module";
    }*/
    @GetMapping("/get")
public List<documentVersionEntity> getData(){
    return Aser.getAllData();
}
    @GetMapping("/get/{id}")
    public  documentVersionEntity getUserData(@PathVariable Long id)
    {
        return Aser.getUserDetails(id);
          
    }
    @PutMapping("/put/{id}")
    public documentVersionEntity updateData (@PathVariable Long id,@RequestBody documentVersionEntity data)
    {
        return Aser.updateDatabase(id,data);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id)
    {
      try{
            documentVersionEntity getData=Aser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }  
    catch(Exception e)
    {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
@PatchMapping("/patch/{id}")
public documentVersionEntity patchData(@PathVariable Long id,@RequestBody documentVersionEntity data) {

       return Aser.patchDatabase(id, data);
}

}

