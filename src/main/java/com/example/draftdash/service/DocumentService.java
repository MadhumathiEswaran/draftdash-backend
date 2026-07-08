package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.documentEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.documentRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class DocumentService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    documentRepository docrepo;

    @Autowired
    public PasswordEncoder passwordEncode;

    public documentEntity saveData(documentEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPassword());
          data.setPassword(BycrpPass);
           return docrepo.save(data);
    }
    
    public List<documentEntity >getAllData()
    {
        return docrepo.findAll();
    }
    public documentEntity  getUserDetails(Long id)
    {
        return docrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public documentEntity updateDatabase(Long id,documentEntity  data)
    {
        documentEntity  viewData=docrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setTitle(data.getTitle());
        viewData.setWorkspace(data.getWorkspace());
        viewData.setCurrentstatus(data.getCurrentstatus());
        viewData.setCreatedby(data.getCreatedby());
        viewData.setPassword(data.getPassword());

        return docrepo.save(viewData);

    }
    public documentEntity  getDelete(Long id)
    {
      documentEntity stu=docrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        docrepo.delete(stu);
        return stu;
    }
    public documentEntity patchDatabase(Long id, documentEntity data) {

    documentEntity existing = docrepo.findById(id)
            .orElseThrow(() -> new UserNotFound( "User not found"));

    if (data.getTitle() != null) {
        existing.setTitle(data.getTitle());
    }

    if (data.getWorkspace() != null) {
        existing.setWorkspace(data.getWorkspace());
    }

    if (data.getCurrentstatus() != null) {
        existing.setCurrentstatus(data.getCurrentstatus());
    }

    if (data.getCreatedby() != null) {
        existing.setCreatedby(data.getCreatedby());
    }

    return docrepo.save(existing);
}

public String generateToken(String gmail){
        return Jwts.builder()
                  .subject(gmail)
                  .issuedAt(new Date())
                  .expiration(new Date(System.currentTimeMillis()+exp))
                  .signWith(getKeys())
                  .compact();
    }
    private Key getKeys(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}

