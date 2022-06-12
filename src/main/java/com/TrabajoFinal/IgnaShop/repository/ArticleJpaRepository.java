package com.TrabajoFinal.IgnaShop.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TrabajoFinal.IgnaShop.entity.ArticleEntity;
import com.TrabajoFinal.IgnaShop.entity.CategoryEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Serializable> {

	
	List<ArticleEntity> findByOrderByRegisterDateDesc();
	
	public List<ArticleEntity> findArticlesByUsersId(UsersEntity usersId);
	
	public ArticleEntity findArticleById(int id);
	
	public List<ArticleEntity> findArticleByUsersIdAndCategoryId(UsersEntity usersId, CategoryEntity categoryId);
	
	public List<ArticleEntity> findArticlesByUsersIdOrderByPriceAsc(UsersEntity usersId);

	@Query("SELECT a FROM ArticleEntity a where stock > 0")
	public List<ArticleEntity> findWithStock();
	
	
	

}
