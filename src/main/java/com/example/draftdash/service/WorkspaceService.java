package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.workSpaceEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.workspaceRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class WorkspaceService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    workspaceRepository wrkrepo;
    @Autowired
    public PasswordEncoder passwordEncode;

    
    public workSpaceEntity saveData(workSpaceEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPassword());
          data.setPassword(BycrpPass);
           return wrkrepo.save(data);
    }

    public List<workSpaceEntity >getAllData()
    {
        return wrkrepo.findAll();
    }
    public workSpaceEntity  getUserDetails(Long id)
    {
        return wrkrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public workSpaceEntity updateDatabase(Long id,workSpaceEntity  data)
    {
        workSpaceEntity  viewData=wrkrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setName(data.getName());
        viewData.setDescription(data.getDescription());
        viewData.setCapacitylimit(data.getCapacitylimit());
        viewData.setStatus(data.getStatus());
        viewData.setOwner(data.getOwner());
        viewData.setPassword(data.getPassword());

        return wrkrepo.save(viewData);
    }
    public workSpaceEntity  getDelete(Long id)
    {
      workSpaceEntity  stu=wrkrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        wrkrepo.delete(stu);
        return stu;
    }
    public workSpaceEntity patchDatabase(Long id, workSpaceEntity data) {

    workSpaceEntity existing = wrkrepo.findById(id)
            .orElseThrow(() -> new UserNotFound("User not found"));

    if (data.getName() != null) {
        existing.setName(data.getName());
    }

    if (data.getDescription() != null) {
        existing.setDescription(data.getDescription());
    }

    if (data.getCapacitylimit() != 0) {
        existing.setCapacitylimit(data.getCapacitylimit());
    }

    if (data.getStatus() != null) {
        existing.setStatus(data.getStatus());
    }

    if (data.getOwner() != null) {
        existing.setOwner(data.getOwner());
    }

    return wrkrepo.save(existing);
}

public String generateToken(String email){
        return Jwts.builder()
                  .subject(email)
                  .issuedAt(new Date())
                  .expiration(new Date(System.currentTimeMillis()+exp))
                  .signWith(getKeys())
                  .compact();
    }
    private Key getKeys(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}

