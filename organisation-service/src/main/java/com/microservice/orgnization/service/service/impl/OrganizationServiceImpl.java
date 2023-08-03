package com.microservice.orgnization.service.service.impl;

import com.microservice.orgnization.service.dto.OrganizationDto;
import com.microservice.orgnization.service.entity.Organization;
import com.microservice.orgnization.service.exception.OrganizationNotFoundException;
import com.microservice.orgnization.service.repository.OrganizationRepository;
import com.microservice.orgnization.service.service.OrganizationService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = modelMapper.map(organizationDto, Organization.class);

        Organization savedOrganization = organizationRepository.save(organization);

        return modelMapper.map(savedOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        if (organization == null) {
            throw new OrganizationNotFoundException("Organization", "organizationCode", organizationCode);
        }
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
