package com.springboottutorials.springboottutorials.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginData
{
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, max = 12, message = "Username must be between 3 - 12 characters!")
    private String userName;

//    @Pattern(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}${2,6}$", message = "Invalid Email!")
    // OR
    @Email(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Email Valid nahi YAAR!")
    private String email;

    @AssertTrue(message = "Oye Agree kar foran!")
    private boolean agreed;
}
