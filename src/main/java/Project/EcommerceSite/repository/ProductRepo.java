package Project.EcommerceSite.repository;

import Project.EcommerceSite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
