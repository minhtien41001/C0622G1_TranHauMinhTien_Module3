package reponsitory;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();
    void edit(int id,Product product);
    void delete(int id);
    void save (Product product);
    List<Product> findByName(String name);
    Product findById(int id);
}
