package service.impl;

import model.Product;
import reponsitory.IProductRepository;
import reponsitory.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> displayAll() {
        return iProductRepository.displayAll();
    }

    @Override
    public void edit(int id, Product product) {
        iProductRepository.edit(id,product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }
}
