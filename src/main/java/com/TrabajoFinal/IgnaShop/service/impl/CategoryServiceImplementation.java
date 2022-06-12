package com.TrabajoFinal.IgnaShop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.CategoryEntity;

import com.TrabajoFinal.IgnaShop.model.CategoryModel;

import com.TrabajoFinal.IgnaShop.repository.CategoryJpaRepository;

import com.TrabajoFinal.IgnaShop.service.CategoryService;


@Service("categoryServiceImpl")
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	@Qualifier("categoryJpaRepository")
	private CategoryJpaRepository categoryJpaRepository;

	@Override
	public CategoryEntity transform(CategoryModel categotyModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(categotyModel, CategoryEntity.class);
	}

	@Override
	public CategoryModel transform(CategoryEntity categoryEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(categoryEntity, CategoryModel.class);
	}

	@Override
	public List<CategoryModel> listAllCategory() {
		return categoryJpaRepository.findAll().stream().
				map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public CategoryEntity findCategoryById(int id) {
		return categoryJpaRepository.findCategoryById(id);
	}

}
