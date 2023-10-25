package baseball;

import java.util.AbstractList;
import java.util.List;

public class ImmutableList<T> extends AbstractList<T> implements List<T> {
    private final List<T> items;

    public ImmutableList(List<T> c) {
        items = c;
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return items.size();
    }
}
