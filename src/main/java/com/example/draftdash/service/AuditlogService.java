package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.auditLogEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.auditlogRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class AuditlogService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    auditlogRepository audrepo;

    @Autowired
    public PasswordEncoder passwordEncode;
    
    public auditLogEntity saveData(auditLogEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPassword());
          data.setPassword(BycrpPass);
           return audrepo.save(data);
    }

    public List<auditLogEntity>getAllData()
    {
        return audrepo.findAll();
    }
    public auditLogEntity getUserDetails(Long id)
    {
        return audrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public auditLogEntity updateDatabase(Long id,auditLogEntity data)
    {
        auditLogEntity viewData=audrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setActor(data.getActor());
        viewData.setTargetentity(data.getTargetentity());
        viewData.setTargetid(data.getTargetid());
        viewData.setDescription(data.getDescription());
        viewData.setPassword(data.getPassword());


        return audrepo.save(viewData);
    }
    public auditLogEntity getDelete(Long id)
    {
        auditLogEntity stu=audrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        audrepo.delete(stu);
        return stu;
    }
    public auditLogEntity patchDatabase(Long id, auditLogEntity data) {

    auditLogEntity existing = audrepo.findById(id)
            .orElseThrow(() -> new UserNotFound( "User not found"));

    if (data.getActor() != null) {
        existing.setActor(data.getActor());
    }

    if (data.getActiontype() != null) {
        existing.setActiontype(data.getActiontype());
    }

    if (data.getTargetentity() != null) {
        existing.setTargetentity(data.getTargetentity());
    }

    if (data.getTargetid() != null) {
        existing.setTargetid(data.getTargetid());
    }

    if (data.getDescription() != null) {
        existing.setDescription(data.getDescription());
    }

    return audrepo.save(existing);
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

