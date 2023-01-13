package com.javi.moby.entity.DTO;

import com.javi.moby.entity.model.Candidate;
import com.javi.moby.entity.model.CandidateXTechnology;
import com.javi.moby.entity.model.Technology;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateXTechnologyDTO {
    Long idCandidateXTechnology;

    private Candidate candidate;

    private Technology technology;

    private int experience;

    /**
     * Method to convert a CandidateXTechnology DTO to a CandidateXTechnology entity.
     */
    public CandidateXTechnology convertDTOToEntity() {
        return new ModelMapper().map(this, CandidateXTechnology.class);
    }
}
