package com.example.draftdash.service;
import java.security.Key;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.draftdash.entity.systemUserEntity;
import com.example.draftdash.exception.UserNotFound;
import com.example.draftdash.repository.systemuserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    systemuserRepository sysrepo;

    @Autowired
    public PasswordEncoder passwordEncode;

    public systemUserEntity saveData(systemUserEntity data)
    {
          String BycrpPass=passwordEncode.encode(data.getPasswordhash());
          data.setPasswordhash(BycrpPass);
           return sysrepo.save(data);
    }

    public List<systemUserEntity>getAllData()
    {
        return sysrepo.findAll();
    }
    public systemUserEntity getUserDetails(Long id)
    {
        return sysrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }
    //new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")//
    public systemUserEntity updateDatabase(Long id,systemUserEntity data)
    {
        systemUserEntity viewData=sysrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        viewData.setId(data.getId());
        viewData.setUsername(data.getUsername());
        viewData.setEmail(data.getEmail());
        viewData.setPasswordhash(passwordEncode.encode(data.getPasswordhash()));
        viewData.setIsactive(data.getIsactive());
        viewData.setCreatedat(data.getCreatedat());
    

        return sysrepo.save(viewData);
    }
    public systemUserEntity getDelete(Long id)
    {
        systemUserEntity stu=sysrepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
        sysrepo.delete(stu);
        return stu;
    }
    public systemUserEntity patchDatabase(Long id, systemUserEntity data) {

    systemUserEntity existing = sysrepo.findById(id)
            .orElseThrow(() -> new UserNotFound( "User not found"));

    if (data.getUsername() != null) {
        existing.setUsername(data.getUsername());
    }

    if (data.getEmail() != null) {
        existing.setEmail(data.getEmail());
    }

    if(data.getPasswordhash()!=null){
    existing.setPasswordhash(passwordEncode.encode(data.getPasswordhash()));
}

    if (data.getIsactive() != null) {
        existing.setIsactive(data.getIsactive());
    }

    if (data.getCreatedat() != null) {
        existing.setCreatedat(data.getCreatedat());
    }

    return sysrepo.save(existing);
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