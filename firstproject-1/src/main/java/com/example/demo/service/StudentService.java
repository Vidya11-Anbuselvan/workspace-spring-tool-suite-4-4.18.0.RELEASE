package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
  
@Autowired
   StudentRepository studRepo;
   

   public List<Student>getAllStudents()
   {
	   List<Student>studList=studRepo.findAll();
	   return studList;
   } 
   
   
   public Student saveStudents(Student u)
   {
	   Student obj= studRepo.save(u);
	   return obj;
   }
   
   
   public  Student updateStudent(Student s,int rno) {
		Optional<Student> optional=studRepo.findById(rno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRegno(s.getRegno());
			obj.setName(s.getName());
			obj.setDept(s.getDept());
			
		studRepo.saveAndFlush(s);
		}
		return obj;	
	}
   
   
   public void deleteStudents(int regno)
   {
	   studRepo.deleteById(regno);   
   }
   
   
   public Student getStudent(int regno)
   {
	   Student s=studRepo.findById(regno).get();
	   return s;
   }
   
   
   public List<Student>sortStudents(String field)
   {
	  // return studRepo.findAll(Sort.by(field));
	   return studRepo.findAll(Sort.by(Direction.DESC,field));
   }
 
  
public List<Student> pagingStudents(int num, int size) {
	Page<Student> obj= studRepo.findAll(PageRequest.of(num, size));
	return obj.getContent();
}
 
public List<Student> paginate(int num, int size, String price) 
{
	Page<Student> obj=studRepo.findAll(PageRequest.of(num, size,Sort.by(price).descending()));
	return obj.getContent();
}

public List<Student>fetchStudentsByNamePrefix(String prefix)
{
	return studRepo.findByNameStartingWith(prefix);
}

public List<Student>fetchStudentsByNameSuffix(String suffix)
{
	return studRepo.findByNameEndingWith(suffix);
}
	
public List<Student>findByDept(String dept)
{
	return studRepo.findByDept(dept);
}
@Transactional
public int updateStudentByName(String dept,String name)
{
	return studRepo.updateStudentByName(dept, name);
}
}
