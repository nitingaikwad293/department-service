package com.nitin.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.departmentservice.dto.DepartmentDto;
import com.nitin.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

 @Autowired	
 private DepartmentService departmentService;
 
 @PostMapping
 public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
	 
	 DepartmentDto dto = departmentService.saveDepartment(departmentDto);
	 
	 return new ResponseEntity<DepartmentDto>(dto, HttpStatus.CREATED);
	 
 }
 
 @GetMapping
 public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
	 
	 List<DepartmentDto> departments = departmentService.getAllDepartments();
	 
	 return new ResponseEntity<List<DepartmentDto>>(departments, HttpStatus.OK);
 }
 
 @GetMapping("{departmentCode}")
 public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode){
	 
	 DepartmentDto dto = departmentService.getDepartmentByCode(departmentCode);
	 
	 return new ResponseEntity<DepartmentDto>(dto, HttpStatus.OK);
	 
 }

}
