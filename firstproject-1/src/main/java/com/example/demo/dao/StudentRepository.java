package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student; 

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	
	
	List<Student>findByNameStartingWith(String prefix);
	List<Student>findByNameEndingWith(String suffix);
	List<Student>findByDept(String dept);
	
	
	@Query("update Student s set s.dept=?1 where s.name=?2")
    public int updateStudentByName(String dept,String name);

}