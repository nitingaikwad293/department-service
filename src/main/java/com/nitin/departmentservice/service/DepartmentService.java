package com.nitin.departmentservice.service;

import java.util.List;

import com.nitin.departmentservice.dto.DepartmentDto;


public interface DepartmentService {
	
	
	public DepartmentDto saveDepartment(DepartmentDto departmentDto);

	public List<DepartmentDto> getAllDepartments();

	public DepartmentDto getDepartmentByCode(String departmentCode);

}
