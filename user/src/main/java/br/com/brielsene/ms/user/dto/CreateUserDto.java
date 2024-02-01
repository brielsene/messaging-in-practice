package br.com.brielsene.ms.user.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank
        String name,
        @NotBlank
        String email


) {
}
