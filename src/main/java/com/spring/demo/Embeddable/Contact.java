package com.spring.demo.Embeddable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

   
    private String phoneNumber;

    @Email
    private String emailAddress;

}
