package com.nitin.departmentservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.departmentservice.dto.DepartmentDto;
import com.nitin.departmentservice.entity.Department;
import com.nitin.departmentservice.repository.DepartmentRepository;
import com.nitin.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		Department department = modelMapper.map(departmentDto, Department.class);
		
		Department savedDepartment = repository.save(department);
		
		DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
		
		return savedDepartmentDto;
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		
		List<DepartmentDto> departments = repository.findAll().stream().map((department)->modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
		
		return departments;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = repository.findByDepartmentCode(departmentCode);
		
		return modelMapper.map(department, DepartmentDto.class);
	}
	

}
