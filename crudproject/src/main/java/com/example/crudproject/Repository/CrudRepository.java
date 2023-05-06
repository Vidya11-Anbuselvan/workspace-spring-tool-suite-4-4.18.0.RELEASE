package com.example.crudproject.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.crudproject.Model.Crud;



@Repository
public interface CrudRepository extends JpaRepository<Crud,Integer>{
	

}