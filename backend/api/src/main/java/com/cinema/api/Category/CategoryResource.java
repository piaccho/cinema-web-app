package com.cinema.api.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryRepository categoryRepository) {
        this.categoryService = new CategoryService(categoryRepository);
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> getCategoryById(@PathVariable("categoryId") String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}
