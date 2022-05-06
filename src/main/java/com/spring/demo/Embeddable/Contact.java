package com.spring.demo.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

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
