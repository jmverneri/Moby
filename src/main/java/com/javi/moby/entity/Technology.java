package com.javi.moby.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technology")
    private Long idTechnology;
    @Column(name = "tec_name")
    @NotEmpty
    private String tecName;
    private String version;

    public Long getIdTechnology() {
        return idTechnology;
    }

    public void setIdTechnology(Long technologyId) {
        this.idTechnology = technologyId;
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

    @Override
    public String toString() {
        return "Technology{" +
                "technologyId=" + idTechnology +
                ", tecName='" + tecName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
