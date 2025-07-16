package Project.EcommerceSite.service;

import Project.EcommerceSite.model.CartItem;
import Project.EcommerceSite.model.Order;
import Project.EcommerceSite.model.User;
import Project.EcommerceSite.repository.CartItemRepo;
import Project.EcommerceSite.repository.OrderRepo;
import Project.EcommerceSite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private UserRepo userRepo;

    public Order placeOrder(String username){
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<CartItem> cartItems = cartItemRepo.findByUser(user);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty, cannot place order");
        }

        double total = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        List<CartItem> orderItems = cartItems.stream().map(cartItem -> {
            CartItem newItem = new CartItem();
            newItem.setProduct(cartItem.getProduct());
            newItem.setUser(user);
            return cartItemRepo.save(newItem);
        }).toList();

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(total);
        order.setItems(orderItems);

        Order savedOrder = orderRepo.save(order);
        cartItemRepo.deleteAll(cartItems);
        return savedOrder;
    }
    public List<Order> getOrders(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepo.findByUser(user);
    }


}
