package kz.dostyk.sportsclub.controller;

import kz.dostyk.sportsclub.entity.User;
import kz.dostyk.sportsclub.service.JwtService;
import kz.dostyk.sportsclub.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> body) {
        return userService.register(
                body.get("username"),
                body.get("password")
        );
    }
    @PostMapping("/register")
    public User register(@RequestParam String username,
                         @RequestParam String password) {
        return userService.register(username, password);
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        User user = userService.login(
                body.get("username"),
                body.get("password")
        );

        String token = jwtService.generateToken(user.getUsername());

        return Map.of("token", token);
    }
}
