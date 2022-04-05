package net.bagpyp.woodie.data.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resident {
    @Id
    @SequenceGenerator(
            name = "resident_sequence",
            sequenceName = "resident_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Getter @Setter private Long id;
    @NotNull
    @Getter @Setter private String firstName;
    @Getter @Setter private Character middleInitial;
    @NotNull
    @Getter @Setter private String lastName;
    @NotNull
    @Getter @Setter private String email;
    @NotNull
    @Getter @Setter private LocalDate birthDate;
    @Transient
    @Setter private Integer age;
    @Getter @Setter private Float rent;

    public Resident(
                    String firstName,
                    Character middleInitial,
                    String lastName,
                    String email,
                    LocalDate birthDate,
                    Float rent) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.rent = rent;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Resident{" +
                "firstName='" + firstName + '\'' +
                ", middleInitial=" + Optional.ofNullable(middleInitial).orElse('_') +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + this.getAge() +
                ", rent=" + rent +
                '}';
    }
}


