package com.javi.moby.entity.model;

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
    @Column(name = "id_number", unique= true)
    private String idNumber;
    @Column(name = "birth_date")
    @DateTimeFormat( pattern="yyyy-MM-dd")
    private Date birthDate;

}
