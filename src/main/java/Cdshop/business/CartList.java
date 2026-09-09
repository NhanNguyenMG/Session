package Cdshop.business;

import java.util.ArrayList;
import java.util.List;


public class CartList {
    private List<CartItem> cartItemList = new ArrayList<>();

    public void addCartItem(CartItem cartItem){
        for(CartItem c : cartItemList) {
            if (cartItem.getDescription().equals(c.getDescription())) {
                c.setQuantity(c.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        cartItemList.add(cartItem);
    }

    public List<CartItem> getCartItemList() {return cartItemList;}
    public double getTotal() {
        double total = 0;
        for (CartItem item : cartItemList) {
            total += item.getAmount();
        }
        return total;
    }
}
