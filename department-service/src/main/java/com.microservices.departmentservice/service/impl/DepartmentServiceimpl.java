package com.microservices.departmentservice.service.impl;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.exception.DepartmentNotFoundException;
import com.microservices.departmentservice.repository.DepartmentRepository;
import com.microservices.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceimpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper; // Inject ModelMapper as a dependency

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert departmentDto to department JPA entity using ModelMapper
        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        // Convert savedDepartment JPA entity to DepartmentDto using ModelMapper
        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

        return savedDepartmentDto;
    }
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if (department == null) {
            throw new DepartmentNotFoundException("Department", "departmentCode", departmentCode);
        }

        // Use ModelMapper to map Department entity to DepartmentDto
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return departmentDto;
    }

}
