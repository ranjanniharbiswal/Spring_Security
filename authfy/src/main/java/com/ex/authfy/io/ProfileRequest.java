package com.ex.authfy.io;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileRequest {

    @NotBlank(message = "Name should not be empty.")
    private String name;
    @Email(message = "Enter Valid Email Address.")
    @NotNull(message = "Email Should not be empty.")
    private String email;
    @Size(min = 6,message = "Password must be atleast 6 charecters")
    private String password;
}
