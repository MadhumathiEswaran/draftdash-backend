package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.reviewCycleEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.reviewcycleRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class ReviewcycleService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    reviewcycleRepository cycrepo;

    @Autowired
    public PasswordEncoder passwordEncode;

    public reviewCycleEntity saveData(reviewCycleEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPassword());
          data.setPassword(BycrpPass);
           return cycrepo.save(data);
    }

    public List< reviewCycleEntity>getAllData()
    {
        return cycrepo.findAll();
    }
    public  reviewCycleEntity getUserDetails(Long id)
    {
        return cycrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public  reviewCycleEntity updateDatabase(Long id, reviewCycleEntity data)
    {
        reviewCycleEntity viewData=cycrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setVersion(data.getVersion());
        viewData.setAssignedreviewer(data.getAssignedreviewer());
        viewData.setDecision(data.getDecision());
        viewData.setFeedbacknotes(data.getFeedbacknotes());
        viewData.setPassword(data.getPassword());


        return cycrepo.save(viewData);
    }
    public  reviewCycleEntity getDelete(Long id)
    {
         reviewCycleEntity stu=cycrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
       cycrepo.delete(stu);
        return stu;
    }
    public reviewCycleEntity patchDatabase(Long id, reviewCycleEntity data) {

    reviewCycleEntity existing = cycrepo.findById(id)
            .orElseThrow(() -> new UserNotFound("User not found"));

    if (data.getVersion() != null) {
        existing.setVersion(data.getVersion());
    }

    if (data.getAssignedreviewer() != null) {
        existing.setAssignedreviewer(data.getAssignedreviewer());
    }

    if (data.getDecision() != null) {
        existing.setDecision(data.getDecision());
    }

    if (data.getFeedbacknotes() != null) {
        existing.setFeedbacknotes(data.getFeedbacknotes());
    }

    return cycrepo.save(existing);
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
