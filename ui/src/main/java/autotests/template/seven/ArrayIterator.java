package autotests.template.seven;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] list;
    private int index;

    public ArrayIterator(T[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.length;
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return list[index++];
    }
}
