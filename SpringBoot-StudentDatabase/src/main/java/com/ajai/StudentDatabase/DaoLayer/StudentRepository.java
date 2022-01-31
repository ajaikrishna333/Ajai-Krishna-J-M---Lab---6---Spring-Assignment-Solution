package com.ajai.StudentDatabase.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajai.StudentDatabase.Entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
