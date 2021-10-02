package com.icons.geographic.start.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CiudadPaisCompressDto {
    @NotEmpty
    private String img;
    @NotEmpty
    private String denominacion;
    @NotEmpty
    private Long cantHabitante;

}
