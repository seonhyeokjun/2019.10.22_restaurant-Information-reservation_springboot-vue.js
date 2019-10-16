package kr.co.seonhyeokjun.eatgo.utils;

import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class JwtUtilTests {

    @Test
    public void createToken(){
        String secret = "12345678901234567890123456789012";

        JwtUtil jwtUtil = new JwtUtil(secret);

        String token = jwtUtil.createToken(1004L, "John");

        assertThat(token, containsString("."));
    }
}