package Project.EcommerceSite.service;

import Project.EcommerceSite.model.CartItem;
import Project.EcommerceSite.model.Product;
import Project.EcommerceSite.model.User;
import Project.EcommerceSite.repository.CartItemRepo;
import Project.EcommerceSite.repository.ProductRepo;
import Project.EcommerceSite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    public CartItem addToCart(Long ProductId, int quantity, String Username ){
        Product product = productRepo.findById(ProductId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = userRepo.findByUsername(Username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setUser(user);

        return cartItemRepo.save(cartItem);
    }
    public List<CartItem> getCartItems(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return cartItemRepo.findByUser(user);
    }

    public void deleteCartItem(Long id) {
        cartItemRepo.deleteById(id);
    }


}
