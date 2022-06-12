package com.TrabajoFinal.IgnaShop.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.CommentEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.CommentModel;
import com.TrabajoFinal.IgnaShop.model.UsersModel;
import com.TrabajoFinal.IgnaShop.repository.CommentJpaRepository;
import com.TrabajoFinal.IgnaShop.service.CommentsService;

@Service
public class CommentsServiceImplementation implements CommentsService {
	
	@Autowired
	@Qualifier("commentJpaRepository")
	private CommentJpaRepository commentJpaRepository;
	
	@Override
	public CommentEntity transform(CommentModel commentModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(commentModel, CommentEntity.class);
	}

	@Override
	public CommentModel transform(CommentEntity commentEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(commentEntity, CommentModel.class);
	}
	
	
	@Override
	public List<CommentEntity> listCommentByReceiverId(UsersEntity usersEntity) {
		return commentJpaRepository.findCommentByReceiverId(usersEntity);
	}

	@Override
	public List<CommentModel> findCommentByReceiverId(UsersModel usersModel) {
		// TODO Esbozo de método generado automáticamente
		return null;
	}
	
	@Override
	public CommentEntity updateComment(CommentEntity comment) {
		return commentJpaRepository.save(comment);
	}


	
}
