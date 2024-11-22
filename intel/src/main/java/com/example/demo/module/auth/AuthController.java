package com.example.demo.module.auth;

import com.example.demo.module.auth.form.LoginForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/common/login")
    public ResponseEntity<?> loginAccount(@RequestBody LoginForm loginForm, HttpServletRequest request){
        try {
            request.login(loginForm.getUsername(), loginForm.getPassword());
            return ResponseEntity.ok("로그인 성공하였습니다.");
        } catch (ServletException e) {
            return ResponseEntity.badRequest().body("로그인에 실패하였습니다.");
        }
    }
    @PostMapping("/api/member/logout")
    public ResponseEntity<?> logout(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseEntity.ok("로그아웃 성공하였습니다.");
    }

    @GetMapping("/api/common/is-login")
    public ResponseEntity<?> isLogin(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(false);
        }

        return ResponseEntity.ok(userDetails.getUsername());
    }
}
