package com.garen.dataStructure.heap;

import java.util.Comparator;

public class MyComparator<T>  implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (int) o2 - (int) o1;
    }
}
