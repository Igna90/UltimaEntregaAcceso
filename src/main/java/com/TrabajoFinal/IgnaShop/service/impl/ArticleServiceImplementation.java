package com.TrabajoFinal.IgnaShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.ArticleEntity;
import com.TrabajoFinal.IgnaShop.entity.CategoryEntity;
import com.TrabajoFinal.IgnaShop.entity.UsersEntity;
import com.TrabajoFinal.IgnaShop.model.ArticleModel;
import com.TrabajoFinal.IgnaShop.model.UsersModel;
import com.TrabajoFinal.IgnaShop.repository.ArticleJpaRepository;
import com.TrabajoFinal.IgnaShop.service.ArticleService;

@Service
public class ArticleServiceImplementation implements ArticleService {

	
	
	@Autowired
	@Qualifier("articleJpaRepository")
	private ArticleJpaRepository articleJpaRepository;

	@Override
	public ArticleEntity transform(ArticleModel articleModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(articleModel, ArticleEntity.class);
	}

	@Override
	public ArticleModel transform(ArticleEntity articleEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(articleEntity, ArticleModel.class);
	}

	@Override
	public ArticleEntity createArticle(ArticleModel articleModel) {
		return articleJpaRepository.save(transform(articleModel));
	}

	@Override
	public List<ArticleModel> findArticlesByUsersId(UsersModel usersModel) {

		return null;
	}

	@Override
	public ArticleEntity findArticleById(int id) {
		return articleJpaRepository.findArticleById(id);
	}
	
	
	@Override
	public void deleteArticle(int id) {
		ArticleEntity article = articleJpaRepository.findArticleById(id);
		articleJpaRepository.delete(article);

	}

	@Override
	public ArticleEntity updateArticle(ArticleModel articleModel) {
		return articleJpaRepository.save(transform(articleModel));
	}

	@Override
	public List<ArticleEntity> listArticlesByUser(UsersEntity usersEntity) {
		return articleJpaRepository.findArticlesByUsersId(usersEntity);
	}

	@Override
	public List<ArticleEntity> listAllArticles(ArticleEntity articleEntity) {
		return articleJpaRepository.findAll();
	}

	public List<ArticleEntity> listArticlesByOrder() {
		return articleJpaRepository.findByOrderByRegisterDateDesc();
	}

	@Override
	public List<ArticleEntity> findArticleByUsersIdAndCategoryId(UsersEntity usersId, CategoryEntity categoryId) {
		return articleJpaRepository.findArticleByUsersIdAndCategoryId(usersId, categoryId);
	}

	public List<ArticleEntity> listArticlesByUsersIdAndPriceAsc(UsersEntity usersId) {
		return articleJpaRepository.findArticlesByUsersIdOrderByPriceAsc(usersId);
	}

	public List<ArticleEntity> findArticleWithStock(){
		return articleJpaRepository.findWithStock();
	}
	
	@Override
	public Optional<ArticleEntity> findById(int id) {
		return articleJpaRepository.findById(id);
	}

	
	@Override
	public int save(ArticleEntity article) {
		int res=0;
		ArticleEntity product=articleJpaRepository.save(article);
		if(!product.equals(null))
			res=1;
		return res;
	}
}



