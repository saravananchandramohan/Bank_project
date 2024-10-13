package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
   private UserService userService;

//    @GetMapping("/login")
//    public String login(){
//     return "login";
//    }
   @PostMapping("/login")
   public ResponseEntity<String> loginUser(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String role
                           ){
        User user=userService.findByUsername(username);
        if(user !=null && user.getPassword().equals(password)&& user.getRole().equals(role)){
            return ResponseEntity.ok("success");
        }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
   }
    
}
