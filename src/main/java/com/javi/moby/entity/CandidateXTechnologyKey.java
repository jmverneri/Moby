package com.javi.moby.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateXTechnologyKey implements Serializable {
    @Column(name = "id_candidate")
    private Long idCandidate;

    @Column(name = "id_technology")
    private Long idTechnology;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateXTechnologyKey that = (CandidateXTechnologyKey) o;
        return Objects.equals(idCandidate, that.idCandidate) && Objects.equals(idTechnology, that.idTechnology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCandidate, idTechnology);
    }
}
