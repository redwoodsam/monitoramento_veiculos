package br.com.aldbio.controle_veiculos.auth.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aldbio.controle_veiculos.auth.controller.dto.RegisterRequestDTO;
import br.com.aldbio.controle_veiculos.auth.entity.User;
import br.com.aldbio.controle_veiculos.auth.repository.UserRepository;
import br.com.aldbio.controle_veiculos.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthService authService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDTO registerForm) {
        if (userRepository.findByUsername(registerForm.username()).isPresent()) {
            return "O usuário já existe!";
        }
        
        User newUser = new User(registerForm.password(), passwordEncoder.encode(registerForm.password()), List.of("USER"));
        userRepository.save(newUser);
        return "Usuário cadastrado co sucesso!";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody RegisterRequestDTO registerForm) {
        return authService.authenticate(registerForm.username(), registerForm.password());
    }

}
