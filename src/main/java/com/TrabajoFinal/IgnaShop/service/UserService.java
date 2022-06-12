package com.TrabajoFinal.IgnaShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.UsersModel;

@Service("userService")
public interface UserService {

	UsersEntity findUserByEmail(String email);

	UsersModel findUserByName(String name);

	UsersModel transform(UsersEntity usersEntity);

	UsersEntity transform(UsersModel usersModel);

	UsersEntity editUser(UsersModel usersModel);

	UsersEntity findeUserById(int id);

	UsersEntity updateUser(UsersEntity user);

	List<UsersEntity> listUsersByOrder();

}
