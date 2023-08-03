package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.dto.APIResponseDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for employee microservice",
        description="Department controller exposing employee microservice"
)
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Save Employee REST API
    @Operation(
            summary = " Employee microservice REST API",
            description = "saveEmployee REST API is used to save department name into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @Operation(
            summary = " Employee microservice REST API",
            description = "getEmployee REST API is used to retrieve employee name from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
