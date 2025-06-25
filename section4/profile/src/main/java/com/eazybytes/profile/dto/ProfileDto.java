package com.eazybytes.profile.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileDto {

    private String name;
    private String mobileNumber;
    private long accountNumber;
    private long cardNumber;
    private long loanNumber;

}
