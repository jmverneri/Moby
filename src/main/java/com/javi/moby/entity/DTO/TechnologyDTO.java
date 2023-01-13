package com.javi.moby.entity.DTO;

import com.javi.moby.entity.model.Technology;
import lombok.*;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TechnologyDTO {
    private Long idTechnology;
    private String tecName;
    private String version;

    /**
     * Method to convert a Technology DTO to a Technology entity.
     */
    public Technology convertDTOToEntity() {
        return new ModelMapper().map(this, Technology.class);
    }
}
