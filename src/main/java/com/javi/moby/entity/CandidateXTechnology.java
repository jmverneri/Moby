package com.javi.moby.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_x_tec")
public class CandidateXTechnology {
    @EmbeddedId
    @Column(name = "id_candidate_x_tec")
    CandidateXTechnologyKey idCandidateXTechnology;

    @ManyToOne
    @MapsId("idCandidate")
    @JoinColumn(name = "id_candidate")
    private Candidate candidate;

    @ManyToOne
    @MapsId("idTechnology")
    @JoinColumn(name = "id_technology")
    private Technology technology;

    private int experience;

}
