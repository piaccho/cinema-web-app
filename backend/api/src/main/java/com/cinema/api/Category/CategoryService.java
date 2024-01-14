package com.cinema.api.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> insertAll(List<Category> categories) {
        List<Category> insertedCategories = new ArrayList<>();

        for (Category category : categories) {
            Optional<Category> existingGenre = categoryRepository.findByCategoryId(category.getCategoryId());

            if (existingGenre.isPresent()) {
                insertedCategories.add(existingGenre.get());
            } else {
                insertedCategories.add(categoryRepository.insert(category));
            }
        }

        return insertedCategories;
    }

    public Category insert(Category category) {
        return categoryRepository.findByCategoryId(category.getCategoryId()).orElseGet(() -> categoryRepository.insert(category));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(String categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }
}
