
package model;
 
import java.util.ArrayList;
import java.util.Hashtable;

public class Shop {
    private ArrayList<Fruit> listFruit= new ArrayList<>();
    private Hashtable<String,ArrayList<Fruit>> orderList= new Hashtable<>();

    public Shop() {
    }
    public void addFruit(Fruit fruit) {
        for(Fruit test:listFruit) {
            if(test.getId().matches(fruit.getId())) {
                test.setQuantity(test.getQuantity()+fruit.getQuantity());
                return;
            }
        }
        listFruit.add(fruit);
        
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public Hashtable<String, ArrayList<Fruit>> getOrderList() {
        return orderList;
    }
    public int orderFruit(Fruit fruit) {
        for(Fruit test:listFruit){
            if(test.getId().matches(fruit.getId())) {
                if(test.getQuantity()<fruit.getQuantity()) return -1;
                else {
                    test.setQuantity(test.getQuantity()-fruit.getQuantity());
                    return 0;
                }                
            }
        }
        return 1;
    }
    public void addOrder(String name,ArrayList<Fruit> order) {
        orderList.put(name, order);
    }
}
