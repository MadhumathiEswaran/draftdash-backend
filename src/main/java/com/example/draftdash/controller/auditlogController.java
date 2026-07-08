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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.draftdash.entity.auditLogEntity;
import com.example.draftdash.service.AuditlogService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/audit")
public class auditlogController {
    @Autowired
    AuditlogService Aser;
    

    @PostMapping("/post")
    public auditLogEntity saveData(@Valid @RequestBody auditLogEntity data)
    {
        return Aser.saveData(data);
    }
    /*@GetMapping("/audit/data")
    public String audit(){
        return "Welcome to Audit Log Module";
    }*/
    @GetMapping("/get")
    public List<auditLogEntity> getData(){
        return Aser.getAllData();
    }
    @GetMapping("/get/{id}")
    public  auditLogEntity getUserData(@PathVariable Long id)
    {
       
             return Aser.getUserDetails(id);
    }
    @PutMapping("/put/{id}")
    public auditLogEntity updateData (@PathVariable Long id,@RequestBody auditLogEntity data)
    {
        return Aser.updateDatabase(id,data);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id)
    {
      try{
            auditLogEntity getData=Aser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }  
    catch(Exception e)
    {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
@PatchMapping("/patch/{id}")
public auditLogEntity patchData(@PathVariable Long id,@RequestBody auditLogEntity data) {

    return Aser.patchDatabase(id, data);
}


}

