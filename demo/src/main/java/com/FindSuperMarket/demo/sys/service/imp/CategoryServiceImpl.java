package com.FindSuperMarket.demo.sys.service.imp;

import com.FindSuperMarket.demo.exception.ResourceNotFoundException;
import com.FindSuperMarket.demo.sys.domain.dto.CategoryDTO;
import com.FindSuperMarket.demo.sys.domain.entity.Category;
import com.FindSuperMarket.demo.sys.domain.mapper.CategoryMapper;
import com.FindSuperMarket.demo.sys.repository.CategoryRepository;
import com.FindSuperMarket.demo.sys.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDTO createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category = categoryRepository.save(category);
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDTOList(categories);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
