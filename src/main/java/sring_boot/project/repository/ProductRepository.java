package sring_boot.project.repository;

import org.springframework.stereotype.Component;
import sring_boot.project.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        String[] titlesProduct = new String[] {"туфли", "платье", "рубашка", "купальник", "брюки"};
        int size = 5;
        productList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            productList.add(new Product(i+1, titlesProduct[i], (i+1)*50));
        }
    }

    public Product saveOrUpdate(Product product) { // сохранить новый или обновить имеющийся
        if (product.getId() != 0) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == product.getId()) {
                    productList.set(i, product);
                    return product;
                }
            }
        }
        Integer newID = productList.stream().mapToInt(Product::getId).max().orElseGet(() -> 0) + 1;
                //находим максимальный id и добавляем 1 ( + 1 )
        product.setId(newID);
        productList.add(product);
        return product;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Optional<Product> getProductById (int id) {
        /*for (Product pr: productList) {
            if (pr.getId() == id) {
                return pr;
            }
        }
        return null;*/
        return productList.stream().filter(pr -> pr.getId() == 0).findFirst();
    }

    public void deleteById(int id) {
        /*for (Product pr: productList) {
            if (pr.getId() == id) {
                productList.remove(id);
            }
        }*/
        productList.removeIf(pr -> pr.getId() == id);
    }

}


