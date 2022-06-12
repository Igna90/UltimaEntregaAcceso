package com.TrabajoFinal.IgnaShop.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.UsersModel;
import com.TrabajoFinal.IgnaShop.repository.UsersJpaRepository;
import com.TrabajoFinal.IgnaShop.service.UserService;

@Service("userServiceImpl")
public class UserServiceImplementation implements UserService {

	@Autowired
	@Qualifier("userJpaRepository")
	private UsersJpaRepository usersJpaRepository;

	@Override
	public UsersModel findUserByName(String name) {
		return usersJpaRepository.findUserByName(name);
	}

	@Override
	public UsersEntity findUserByEmail(String email) {
		return usersJpaRepository.findUserByEmail(email);

	}

	@Override
	public UsersEntity transform(UsersModel usersModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usersModel, UsersEntity.class);
	}

	@Override
	public UsersModel transform(UsersEntity usersEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usersEntity, UsersModel.class);
	}

	@Override
	public UsersEntity editUser(UsersModel usersModel) {
		return usersJpaRepository.save(transform(usersModel));
	}

	@Override
	public UsersEntity findeUserById(int id) {
		return usersJpaRepository.findUserById(id);
	}

	@Override
	public UsersEntity updateUser(UsersEntity userEntity) {
		return usersJpaRepository.save(userEntity);
	}
	
	
	
	public List<UsersEntity> listUsersByOrder() {
		return usersJpaRepository.findByOrderByNumVentasDesc();
	}

	

}
