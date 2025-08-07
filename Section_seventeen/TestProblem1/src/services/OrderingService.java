package services;

import java.util.ArrayList;
import java.util.List;

public class OrderingService<T> {

    public static <T extends Comparable<T>> List<T> orderingCountries(List<T> list) {
        T maxInhabitants = list.get(0);
        T minInhabitants = list.get(0);
        List<T> minAndMax = new ArrayList<>();

        for (T item : list) {
            if (item.compareTo(maxInhabitants) > 0) {
                maxInhabitants = item;
            }

            if (item.compareTo(minInhabitants) < 0) {
                minInhabitants = item;
            }
        }

        minAndMax.add(maxInhabitants);
        minAndMax.add(minInhabitants);

        return  minAndMax;
    }
}
