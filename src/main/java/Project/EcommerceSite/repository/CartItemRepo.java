package Project.EcommerceSite.repository;

import Project.EcommerceSite.model.CartItem;
import Project.EcommerceSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
