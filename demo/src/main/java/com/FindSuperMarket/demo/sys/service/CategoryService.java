package com.FindSuperMarket.demo.sys.service;

import com.FindSuperMarket.demo.sys.domain.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(String name);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
    void deleteCategory(Long id);
}
