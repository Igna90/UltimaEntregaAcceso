package com.TrabajoFinal.IgnaShop.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrabajoFinal.IgnaShop.entity.UsersEntity;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<UsersEntity, String>{
	UsersEntity findByEmailIgnoreCase(String email);
	public UsersEntity findUserByEmail(String email);
}
