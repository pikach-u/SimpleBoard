package com.pikachu.simple_board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    @NotBlank
    @Size(min=3, max=10)
    private String username;

    @NotBlank
    @Size(min=6, max=15)
    private String password;
}
