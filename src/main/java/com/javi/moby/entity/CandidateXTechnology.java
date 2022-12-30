package com.javi.moby.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @Column(name = "id_candidate_x_tec")
    Long idCandidateXTechnology;

    @ManyToOne
    @JoinColumn(name = "id_candidate")
    @JsonIgnore
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "id_technology")
    private Technology technology;

    private int experience;

}
