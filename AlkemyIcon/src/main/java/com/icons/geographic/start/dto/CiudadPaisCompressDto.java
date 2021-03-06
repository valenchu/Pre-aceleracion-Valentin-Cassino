package com.icons.geographic.start.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CiudadPaisCompressDto
{
    @JsonProperty(access = Access.READ_ONLY)
    Long id;

    @NotEmpty
    private String img;

    @NotEmpty
    private String denominacion;

    @NotEmpty
    private Long cantHabitante;

}
