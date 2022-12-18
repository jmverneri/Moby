package com.javi.moby.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technologyId;
    @Column(name = "tec_name")
    @NotEmpty
    private String tecName;
    private String version;
    @ManyToMany
    @JoinTable(name = "candidate_x_tec",
            joinColumns = @JoinColumn(name = "technology_id"),
            inverseJoinColumns = @JoinColumn(name = "id_candidate")
    )
    private List<Candidate> candidateList;

    public Technology() {
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public String getName(String tecName) {
        return tecName;
    }

    public void setName(String name) {
        this.tecName = name;
    }

    public String getVersion(String version) {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "technologyId=" + technologyId +
                ", tecName='" + tecName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
