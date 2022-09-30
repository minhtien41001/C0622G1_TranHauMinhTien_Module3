package reponsitory.impl;

import model.Product;
import reponsitory.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer,Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Vàng mã", 15000, "Tháng cô hồn, sale 10% cho người có vong theo.", "ThuiVy-DaiLoi company"));
        productMap.put(2, new Product(2, "Áo thun MU", 100000, "Đi lên từ đáy xã hội.", "HoMinhTri company"));
        productMap.put(3, new Product(3, "Durex vị bánh trung thu", 45000, "Thêm dư vị cho Tết trung thu.", "ThuiVy-DaiLoi company"));
        productMap.put(4, new Product(4, "Durex vị cần sa", 50000, "Mua 2 hộp, tặng 1 áo đấu Harry Maguire.", "HoMinhTri company"));
        productMap.put(5, new Product(5, "Dầu ăn Hùng Nam", 18000, "Dầu ăn Hùng Nam, nhuộm cam bảo kiếm.", "HungNam company"));
    }
    @Override
    public List<Product> displayAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void edit(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : displayAll()) {
            if (item.getName().contains(name)) {
                searchList.add(item);
            }
        }
        return searchList;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
