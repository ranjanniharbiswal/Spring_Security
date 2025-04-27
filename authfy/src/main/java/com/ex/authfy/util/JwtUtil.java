package com.ex.authfy.util;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtil {

    public String generateToken(UserDetails userDetails){
        Map<String , Objects> cliams=new HashMap<>();
    }
}
