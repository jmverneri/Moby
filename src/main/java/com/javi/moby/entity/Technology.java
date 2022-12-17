package com.javi.moby.entity;

import jakarta.persistence.*;

@Entity
@Table(name="technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technologyId;
    @Column(name = "tec_name")
    private String tecName;
    private String version;

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

    @Override
    public String toString() {
        return "Technology{" +
                "technologyId=" + technologyId +
                ", name='" + tecName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
