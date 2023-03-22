package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.enumerations.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
}
