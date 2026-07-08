package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.documentVersionEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.documentversionRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class DocumentversionService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    documentversionRepository docvrepo;

    @Autowired
    public PasswordEncoder passwordEncode;

    public documentVersionEntity saveData(documentVersionEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPassword());
          data.setPassword(BycrpPass);
           return docvrepo.save(data);
    }

    public List<documentVersionEntity >getAllData()
    {
        return docvrepo.findAll();
    }
    public documentVersionEntity  getUserDetails(Long id)
    {
        return docvrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public documentVersionEntity updateDatabase(Long id,documentVersionEntity  data)
    {
        documentVersionEntity  viewData=docvrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setTitle(data.getTitle());
        viewData.setVersionnumber(data.getVersionnumber());
        viewData.setContentdelta(data.getContentdelta());
        viewData.setCommitmessage(data.getCommitmessage());
        viewData.setAuthor(data.getAuthor());
        viewData.setPassword(data.getPassword());

        return docvrepo.save(viewData);
    }
    public documentVersionEntity  getDelete(Long id)
    {
      documentVersionEntity stu=docvrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        docvrepo.delete(stu);
        return stu;
    }
    public documentVersionEntity patchDatabase(Long id, documentVersionEntity data) {

    documentVersionEntity existing = docvrepo.findById(id)
            .orElseThrow(() -> new UserNotFound("User not found"));

    if (data.getTitle() != null) {
        existing.setTitle(data.getTitle());
    }

    if (data.getVersionnumber() != null) {
        existing.setVersionnumber(data.getVersionnumber());
    }

    if (data.getContentdelta() != null) {
        existing.setContentdelta(data.getContentdelta());
    }

    if (data.getCommitmessage() != null) {
        existing.setCommitmessage(data.getCommitmessage());
    }

    if (data.getAuthor() != null) {
        existing.setAuthor(data.getAuthor());
    }

    return docvrepo.save(existing);
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

