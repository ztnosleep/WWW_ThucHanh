package iuh.fit.lab04.daos;

import iuh.fit.lab04.models.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
}
