package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
