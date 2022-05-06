package com.spring.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.demo.Embeddable.Address;
import com.spring.demo.Embeddable.Contact;
import com.spring.demo.Enum.Gender;
import com.spring.demo.Enum.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Students {

    @Id
    @SequenceGenerator(allocationSize = 1,
            sequenceName = "student_sequence", name = "student_sequence")
    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)
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

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "school_year")
    private SchoolYear schoolYear;

    @Embedded
    private Address studentAddress;

    @Embedded
    private Contact studentContact;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDate dateTime;

}
