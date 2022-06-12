package com.TrabajoFinal.IgnaShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TrabajoFinal.IgnaShop.entity.CategoryEntity;

import com.TrabajoFinal.IgnaShop.model.CategoryModel;

@Service("categoryService")
public interface CategoryService {

	CategoryModel transform(CategoryEntity categoryEntity);

	CategoryEntity transform(CategoryModel categoryModel);

	List<CategoryModel> listAllCategory();
	
	CategoryEntity findCategoryById(int id);

}
