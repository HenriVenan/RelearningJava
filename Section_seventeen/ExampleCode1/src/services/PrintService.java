package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private final List<T> numberList = new ArrayList<>();

    public void addValue(T value) {
        numberList.add(value);
    }

    public T first() {
        if (numberList.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return numberList.get(0);
    }

    public void print() {
        StringBuilder str = new StringBuilder("[");

       for (int i = 0; i < numberList.size(); i++) {
           if (i == (numberList.size() - 1)) {
               str.append(numberList.get(i));
           }

           else {
               str.append(numberList.get(i)).append(", ");
           }
       }

       str.append("]");

       System.out.println("\n" + str);
    }
}
