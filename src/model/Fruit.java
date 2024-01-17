
package model;
public class Fruit {
    private String id,fruitName,origin;
    private int price,quantity;

    public Fruit(Fruit fruit) {
        this.id=fruit.getId();
        this.fruitName=fruit.getFruitName();
        this.price=fruit.getPrice();
        this.origin=fruit.getOrigin();
        this.quantity=fruit.getQuantity();
    }
    public Fruit(String id, String fruitName, int price, String origin, int quantity) {
        this.id = id;
        this.fruitName = fruitName;
        this.price = price;
        this.origin = origin;
        this.quantity = quantity;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return fruitName + "| price=" + price + "$ | origin:" + origin + " | quantity=" + quantity;
    }
    
}
