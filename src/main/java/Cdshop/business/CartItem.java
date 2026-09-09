package Cdshop.business;

public class CartItem {
    private String description;
    private double price;
    private int quantity;

    public CartItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() { return description;}
    public double getPrice(){ return price;}
    public int getQuantity() { return quantity;}

    public void setQuantity(int quantity) { this.quantity = quantity;}
    public double getAmount(){return quantity * price;}
}
