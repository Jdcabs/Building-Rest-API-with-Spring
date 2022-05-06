package com.spring.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.demo.Embeddable.Address;
import com.spring.demo.Embeddable.Contact;
import com.spring.demo.Enum.Gender;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Professor {

    @Id
    @SequenceGenerator( allocationSize = 1,
                        name = "professor_sequence",
                        sequenceName = "professor_sequence")
    @GeneratedValue(generator = "professor_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "gender")
    private Gender genderEnum;

    @Embedded
    private Address professorAddress;

    @Embedded
    private Contact professorContact;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDate date;
}
