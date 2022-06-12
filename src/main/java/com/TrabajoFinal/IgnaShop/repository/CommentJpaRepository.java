package com.TrabajoFinal.IgnaShop.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrabajoFinal.IgnaShop.entity.CommentEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;

public interface CommentJpaRepository extends JpaRepository<CommentEntity, Serializable> {
	
	
	public List<CommentEntity> findCommentByReceiverId(UsersEntity receiverId);

}
