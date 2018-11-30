package demo.demo.service;

import demo.demo.model.Book;
import demo.demo.model.Category;
import demo.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(String id) {
        return categoryRepository.findById(id);
    }
    public Category updateById(Category category){
        return categoryRepository.save(category);
    }
    public void deleteById(String id){
        categoryRepository.deleteById(id);
    }
}
