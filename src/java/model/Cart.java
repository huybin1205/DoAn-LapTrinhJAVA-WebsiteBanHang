/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author HuyBin
 */
public class Cart {

    private ArrayList<CartItem> cart;

    public Cart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    public Cart() {
        cart = new ArrayList<>();
    }

    public void checkCart(ArrayList<CartItem> cart) {
        if (cart == null) {
            cart = new ArrayList();
        }
    }

    // insert item to cart
    public void plusItemToCart(Product product) {
//        checkCart(this.cart);
        if (this.getCountItemCart() == 0) {
            cart.add(new CartItem(product, 1));
        } else {
            for (CartItem c : cart) {
                if (c.getProduct().getProductID() == product.getProductID()) {
                    int quantity_old = c.getQuantity();
                    c.setQuantity(quantity_old + 1);
                } else {
                    cart.add(new CartItem(product, 1));
                }
                break;
            }
        }
    }

    public boolean isCheck(ArrayList<CartItem> cart, Product product) {
        for (CartItem c : cart) {
            if (c.getProduct().getProductID() == product.getProductID()) {
                return true;
            }
        }
        return false;
    }

    // insert item to cart and quantity
    public void plusItemToCart(Product product, int quantity) {
        boolean isCheck = isCheck(cart, product);

        if (isCheck) {
            for (CartItem c : cart) {
                if (c.getProduct().getProductID() == product.getProductID()) {
                    int quantity_old = c.getQuantity();
                    c.setQuantity(quantity_old + quantity);
                    break;
                }
            }
        } else {
            cart.add(new CartItem(product, quantity));
        }
    }
    
    // Update cart
    public void updateItemCart(Product product, int quantity) {
        boolean isCheck = isCheck(cart, product);
        if (isCheck) {
            for (CartItem c : cart) {
                if (c.getProduct().getProductID() == product.getProductID()) {
                    if(quantity <= 1){
                        c.setQuantity(1);
                    }else{
                        c.setQuantity(quantity);
                    }
                    break;
                }
            }
        }
    }

    //sub item to cart
    public void subItemToCart(Product product) {
        boolean isCheck = isCheck(cart, product);
        if (isCheck) {
            for (CartItem c : cart) {
                if (c.getProduct().getProductID() == product.getProductID()) {
                    int quantity_old = c.getQuantity();
                    int quantity_new = quantity_old - 1;
                    if (quantity_new < 1) {
                        cart.remove(c);
                    } else {
                        c.setQuantity(quantity_new);
                    }
                }
                break;
            }
        }
    }

    // Total
    public int getTotalCart() {
//        checkCart(cart);
        int total = 0;
        for (CartItem c : cart) {
            total += (c.getProduct().getProductPrice() * c.getQuantity());
        }
        return total;
    }

    // Remove item
    public void removeItemCart(int productID) {
//        checkCart(cart);
        for (CartItem c : cart) {
            if (c.getProduct().getProductID() == productID) {
                cart.remove(c);
                break;
            }
        }
    }

    // Count item
    public int getCountItemCart() {
//        checkCart(cart);
        return cart.size();
    }

    public String formatDecimal(float number) {
        Locale locale = new Locale("vi", "VN");  
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String moneyString = formatter.format(number);
        return moneyString;
    }
}
