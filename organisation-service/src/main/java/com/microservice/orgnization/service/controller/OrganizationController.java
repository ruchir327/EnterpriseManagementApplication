package com.microservice.orgnization.service.controller;

import com.microservice.orgnization.service.dto.OrganizationDto;
import com.microservice.orgnization.service.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
@Tag(
        name = "CRUD REST APIs for organization microservice",
        description="Department controller exposing employee microservice"
)
public class OrganizationController {

    private OrganizationService organizationService;

    // Build Save Organization REST API
    @Operation(
            summary = " Organization microservice REST API",
            description = "saveOrganization REST API is used to save organization name into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @Operation(
            summary = " Organization microservice REST API",
            description = "getOrganization REST API is used to get organization name into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 OK"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}
