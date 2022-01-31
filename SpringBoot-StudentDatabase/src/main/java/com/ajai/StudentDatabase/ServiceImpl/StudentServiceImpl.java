package com.ajai.StudentDatabase.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajai.StudentDatabase.DaoLayer.StudentRepository;
import com.ajai.StudentDatabase.DaoLayer.RoleRepository;
import com.ajai.StudentDatabase.DaoLayer.UserRepository;
import com.ajai.StudentDatabase.Entity.Student;
import com.ajai.StudentDatabase.Entity.Role;
import com.ajai.StudentDatabase.Entity.User;
import com.ajai.StudentDatabase.Service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Service

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public List<Student> findAllStudents() {
//		List<Employee> eList = employeeRepository.findAll();
		
		Student student = new Student();
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withIgnorePaths("s_name","student_id", "department", "country");
		Example<Student> example = Example.of(student, exampleMatcher);

		List<Student> sList = studentRepository.findAll(example);
		
		if (sList.isEmpty()) {
			throw new RuntimeException("No Students found in Database");
		}
		return sList;
	}

	@Override
	public Optional<Student> findStudentById(long student_id) {
		Optional<Student> student = studentRepository.findById(student_id);

		if (student == null) {
			throw new RuntimeException("Student with id : " + student_id + " not found");
		}

		return student;
	}

	@Override
	public List<Student> findStudentByName(String s_name) {
		Student employee = new Student();
		employee.setS_name(s_name);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("s_name", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("department", "country", "student_id");
		Example<Student> example = Example.of(employee, exampleMatcher);

		List<Student> eList = studentRepository.findAll(example);

		if (eList.isEmpty()) {
			throw new RuntimeException("Students with Name : " + s_name + " not found");
		}

		return eList;
	}

	
	@Override
	public void deleteStudentById(long student_id) {
		studentRepository.deleteById(student_id);
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}


}
