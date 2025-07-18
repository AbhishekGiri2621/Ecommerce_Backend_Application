package Project.EcommerceSite.repository;

import Project.EcommerceSite.model.Order;
import Project.EcommerceSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
