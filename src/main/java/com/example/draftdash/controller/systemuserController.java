package com.example.draftdash.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.draftdash.entity.systemUserEntity;
import com.example.draftdash.service.AuthService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/system")
public class systemuserController {
    @Autowired
    AuthService Aser;
    @PostMapping("/post")
    public systemUserEntity saveData(@Valid @RequestBody systemUserEntity data)
    {
        return Aser.saveData(data);
    }
   
    @GetMapping("/get")
    public List<systemUserEntity> getData(){
        return Aser.getAllData();
    }
    @GetMapping("/get/{id}")
    public systemUserEntity getUserData(@PathVariable Long id)
    {
      return Aser.getUserDetails(id);
    }
    @PutMapping("/put/{id}")
    public systemUserEntity updateData ( @PathVariable Long id,@RequestBody systemUserEntity data)
    {
        return Aser.updateDatabase(id,data);
    }

    @DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable Long id){
    return ResponseEntity.ok(Aser.getDelete(id));
}
@PatchMapping("/patch/{id}")
public systemUserEntity patchData( @PathVariable Long id,@RequestBody systemUserEntity data) {

    return Aser.patchDatabase(id, data);
}

@PostMapping("/get/gmail")
   public String generateToken(@RequestParam("mail") String gmail){
      return Aser.generateToken(gmail);
   }
}
