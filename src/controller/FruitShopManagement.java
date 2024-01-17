package controller;

import java.util.ArrayList;
import java.util.Enumeration;
import model.Fruit;
import model.Shop;
import view.Menu;

public class FruitShopManagement extends Menu {

    public static String[] choices = {"Create fruit", "View orders", "Shopping", "Exit"};
    private Shop shop = new Shop();

    public FruitShopManagement() {
        super("Fruit Shop:", choices);
    }

    public void displayFruitList(ArrayList<Fruit> fruitList) {
        int count = 0;
        for (Fruit test : fruitList) {
            System.out.print(++count + ".");
            System.out.println(test);
        }
    }

    public void createFruit() {
        boolean continueR = true;
        while (continueR) {
            String id, fruitName, origin;
            int price, quantity;
            id = Input.getString("fruit id");
            fruitName = Input.getString("fruit name");
            price = Input.getInt("price");
            origin = Input.getString("origin");
            quantity = Input.getInt("quantity");
            shop.addFruit(new Fruit(id, fruitName, price, origin, quantity));
            System.out.println("Sucessfull.");
            System.out.print("Do you want to continue(Y/N)?");
            String input = Input.getNextString();
            if (!input.matches("Y")) {
                continueR = false;
            }
        }
        System.out.println("List of fruits in shop:");
        displayFruitList(shop.getListFruit());
    }

    public void viewOrders() {
        Enumeration<String> keys = shop.getOrderList().keys();
        int[] totalCost = new int[shop.getOrderList().size()];
        int count = -1;
        while (keys.hasMoreElements()) {
            String customer = keys.nextElement();
            ArrayList<Fruit> orderList = shop.getOrderList().get(customer);
            System.out.println("Cusomter:" + customer);
            System.out.println("List order:");
            totalCost[++count] = 0;
            for (Fruit test : orderList) {
                totalCost[count] += test.getPrice();
                System.out.println(test);
            }
            System.out.println("Total cost:" + totalCost[count] + "$");
            System.out.println("");
        }
    }

    public void doShopping() {
        ArrayList<Fruit> orderList = new ArrayList<>();
        int totalCost = 0;
        boolean continueR = true;
        while (continueR) {
            System.out.println("List of fruits in shop:");
            displayFruitList(shop.getListFruit());
            int choice = Input.getInt("item number");
            Fruit selectedFruit = new Fruit(shop.getListFruit().get(choice - 1));
            int quantity = Input.getInt("quantity");
            selectedFruit.setQuantity(quantity);
            selectedFruit.setPrice(selectedFruit.getPrice() * quantity);
            totalCost += selectedFruit.getPrice();
            int validOrder = shop.orderFruit(selectedFruit);
            if (validOrder == -1) {
                System.out.println("Not enough amount.");
            } else if (validOrder == 1) {
                System.out.println("Item doesn't exist.");
            } else {
                orderList.add(selectedFruit);
            }
            System.out.print("Do you want to continue order(Y/N)?");
            String input = Input.getNextString();
            if (!input.matches("Y")) {
                continueR = false;
            }
        }
        displayFruitList(orderList);
        System.out.println("Total:" + totalCost + "$");
        String customerName = Input.getString("name");
        shop.addOrder(customerName, orderList);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                createFruit();
                break;
            case 2:
                viewOrders();
                break;
            case 3:
                doShopping();
                break;
            case 4:
                exitMenu();
                break;
            default:
                break;
        }
    }

}
