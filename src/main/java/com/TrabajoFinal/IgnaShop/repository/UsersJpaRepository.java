package com.TrabajoFinal.IgnaShop.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.UsersModel;



@Repository("userJpaRepository")
public interface UsersJpaRepository extends JpaRepository<UsersEntity, Serializable>{
	
	
	public UsersModel findUserByName(String name);
	public UsersEntity findUserByEmail(String email);
	public UsersEntity findUserById(int id);
	List<UsersEntity> findByOrderByNumVentasDesc();


	
} 
