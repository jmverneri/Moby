package com.javi.moby.entity.DTO;

import com.javi.moby.entity.model.Candidate;
import lombok.*;
import org.modelmapper.ModelMapper;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDTO {

    private Long idCandidate;

    private String firstName;

    private String surname;

    private String identityType;

    private String idNumber;

    private Date birthDate;

    /**
     * Method to convert a Candidate DTO to a Candidate entity.
     */
    public Candidate convertDTOToEntity() {
        return new ModelMapper().map(this, Candidate.class);
    }
}
