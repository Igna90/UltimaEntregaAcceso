package com.TrabajoFinal.IgnaShop.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import com.TrabajoFinal.IgnaShop.entity.CategoryEntity;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Serializable> {

	public CategoryEntity findCategoryById(int id);
	
}
