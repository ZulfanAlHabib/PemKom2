package inventarisapp;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> {
    private List<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    public <E> void printItems(List<E> itemList) {
        for (E item : itemList) {
            System.out.println(item);
        }
    }
}    
