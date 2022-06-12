package com.TrabajoFinal.IgnaShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.UsersEntity;

import com.TrabajoFinal.IgnaShop.repository.UsersJpaRepository;



@Service("userDetailsServiceImplementation")
public class userDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UsersJpaRepository usersJpaRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 UsersEntity user = usersJpaRepository.findUserByEmail(email);
			UserBuilder builder = null;

			if(user != null) {
				builder = User.withUsername(email);
				builder.password(user.getPassword());
				
			}else {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
			return builder.build();
		}
	
	
	
}