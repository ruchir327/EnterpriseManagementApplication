package com.microservice.orgnization.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "OrganizationDto Model Information"
)
public class OrganizationDto {
    @Schema(
            description = "OrganizationDto id"
    )
    private Long id;
    @Schema(
            description = "OrganizationDto organizationName"
    )
    private String organizationName;
    @Schema(
            description = "OrganizationDto organizationDescription"
    )
    private String organizationDescription;
    @Schema(
            description = "EmployeeDto Model organizationCode"
    )
    private String organizationCode;
    @Schema(
            description = "EmployeeDto createdDate"
    )
    private LocalDateTime createdDate;
}
