package com.pikachu.simple_board.controller;

import com.pikachu.simple_board.dto.SignupDto;
import com.pikachu.simple_board.model.User;
import com.pikachu.simple_board.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupDto", new SignupDto());

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
            @Valid @ModelAttribute SignupDto signupDto,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) return "signup";

        if (userRepository.findByUsername(signupDto.getUsername()).isPresent()) { //값 존재여부에 따라 bool값 반환
            model.addAttribute("error", "이미 사용중인 아이디입니다.");

            return "signup";
        }
        userRepository.save(User.builder()
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .build());
        return "redirect:/login?registered";
    }
}
