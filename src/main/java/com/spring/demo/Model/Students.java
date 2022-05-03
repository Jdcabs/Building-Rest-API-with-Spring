package com.spring.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Students {

    @Id
    @SequenceGenerator(allocationSize = 1,
            sequenceName = "student_sequence", name = "student_sequence")
    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private int age;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender genderEnum;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SchoolYear schoolYear;

}
