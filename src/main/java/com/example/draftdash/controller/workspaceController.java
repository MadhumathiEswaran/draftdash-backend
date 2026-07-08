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
import com.example.draftdash.entity.workSpaceEntity;
import com.example.draftdash.service.WorkspaceService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/space")
public class workspaceController {
    @Autowired
    WorkspaceService Aser;
    @PostMapping("/postData")
    public workSpaceEntity saveData(@Valid @RequestBody workSpaceEntity data)
    {
        return Aser.saveData(data);
    }
    /* @GetMapping("/workspace/data")
     public String workspace(){
        return "Welcome to Workspace Module";
     }*/ 
    @GetMapping("/get")
public List<workSpaceEntity> getData(){
    return Aser.getAllData();
}
    @GetMapping("/get/{id}")
    public  workSpaceEntity getUserData(@PathVariable Long id)
    {
        return Aser.getUserDetails(id);
           
    }
    @PutMapping("/put/{id}")
    public workSpaceEntity updateData (@PathVariable Long id,@RequestBody workSpaceEntity data)
    {
        return Aser.updateDatabase(id,data);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id)
    {
      try{
            workSpaceEntity getData=Aser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }  
    catch(Exception e)
    {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
@PatchMapping("/patch/{id}")
public workSpaceEntity patchData(@PathVariable Long id,@RequestBody workSpaceEntity data) {

    return Aser.patchDatabase(id, data);
}

}
