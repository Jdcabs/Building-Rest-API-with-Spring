package com.spring.demo.Embeddable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private int houseNumber;

    private String streetName;

    private String barangay;

    private String cityAndMunicipality;

}
