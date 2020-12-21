package sring_boot.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sring_boot.project.model.Product;
import sring_boot.project.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // сам создаст конструктор и заинжектит сюда ПродуктРепозиторий
public class ProductRepoService {
    private final ProductRepository productRepository;

    public Product saveOrUpdate (Product product) {
        return productRepository.saveOrUpdate(product);
    }

    public List<Product> showAll() {
        return productRepository.getProductList();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void deleteProductById (int id) {
        productRepository.deleteById(id);
    }

}
