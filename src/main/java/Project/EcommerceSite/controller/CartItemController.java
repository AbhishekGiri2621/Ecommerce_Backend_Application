package Project.EcommerceSite.controller;

import Project.EcommerceSite.model.CartItem;
import Project.EcommerceSite.service.CartItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Item")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add/{productId}")
    public CartItem addToCart(@PathVariable Long productId, @RequestParam int quantity, Authentication authentication) {
        String username = authentication.getName();
        return cartItemService.addToCart(productId, quantity, username);
    }

    @GetMapping
    public List<CartItem> getCartItems(Authentication authentication) {
        String username = authentication.getName();
        return cartItemService.getCartItems(username);
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
    }
}
