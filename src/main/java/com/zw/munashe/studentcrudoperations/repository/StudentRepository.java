package com.zw.munashe.studentcrudoperations.repository;

import com.zw.munashe.studentcrudoperations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
