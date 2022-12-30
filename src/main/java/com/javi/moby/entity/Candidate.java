package com.javi.moby.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidate")
    private Long idCandidate;
    @Column(name = "first_name")
    @NotEmpty(message = "You have to complete your name")
    private String firstName;
    @Column(name = "surname")
    @NotEmpty(message = "You have to complete your surname")
    private String surname;
    @Column(name = "identity_type")
    private String identityType;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "birth_date")
    @DateTimeFormat( pattern="yyyy-MM-dd")
    private Date birthDate;

    public Long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Long idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getFirstName(String firstName) {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "idCandidate=" + idCandidate +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", identityType='" + identityType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
