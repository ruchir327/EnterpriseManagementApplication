package com.microservices.employeeservice.dto;

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
        description = "EmployeeDto Model Information"
)
public class EmployeeDto {
    @Schema(
            description = "EmployeeDto Model id"
    )
    private Long id;
    @Schema(
            description = "EmployeeDto Model firstName"
    )
    private String firstName;
    @Schema(
            description = "EmployeeDto Model lastName"
    )
    private String lastName;
    @Schema(
            description = "EmployeeDto Model email"
    )
    private String email;
    @Schema(
            description = "EmployeeDto Model departmentCode"
    )
    private String departmentCode;
    @Schema(
            description = "EmployeeDto Model organizationCode"
    )
    private String organizationCode;
}
