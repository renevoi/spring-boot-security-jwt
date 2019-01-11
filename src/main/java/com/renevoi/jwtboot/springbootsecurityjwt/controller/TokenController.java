package com.renevoi.jwtboot.springbootsecurityjwt.controller;


import com.renevoi.jwtboot.springbootsecurityjwt.model.JwtUser;
import com.renevoi.jwtboot.springbootsecurityjwt.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){

        return jwtGenerator.generate(jwtUser);
    }

}
