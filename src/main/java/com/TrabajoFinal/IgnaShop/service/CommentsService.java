package com.TrabajoFinal.IgnaShop.service;

import java.util.List;

import com.TrabajoFinal.IgnaShop.entity.CommentEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.CommentModel;
import com.TrabajoFinal.IgnaShop.model.UsersModel;

public interface CommentsService {

	CommentModel transform(CommentEntity commentEntity);

	CommentEntity transform(CommentModel commentModel);
	
	List<CommentModel> findCommentByReceiverId(UsersModel usersModel);
	
	List<CommentEntity> listCommentByReceiverId(UsersEntity usersEntity);
	
	CommentEntity updateComment(CommentEntity comment);
	
}
