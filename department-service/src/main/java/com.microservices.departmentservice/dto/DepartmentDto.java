package com.microservices.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "DepartmentDto Model Information"
)
public class DepartmentDto {
    @Schema(
            description = "Department dto id"
    )
    private Long id;
    @Schema(
            description = "Department dto id departmentName"
    )
    private String departmentName;
    @Schema(
            description = "department dto departmentDescription"
    )
    private String departmentDescription;
    @Schema(
            description = "department dto departmentCode"
    )
    private String departmentCode;
}
