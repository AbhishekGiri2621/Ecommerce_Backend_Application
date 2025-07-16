package Project.EcommerceSite.controller;

import Project.EcommerceSite.model.Order;
import Project.EcommerceSite.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/checkout")
    public Order placeOrder(Authentication authentication){
        String username = authentication.getName();
        return orderService.placeOrder(username);
    }
    @GetMapping
    public Order getOrders(Authentication authentication){
        String username = authentication.getName();
        return (Order) orderService.getOrders(username);
    }
}
