package baseball.util;

import java.util.Collection;

public class CollectionUtil {
    public static <E>
    void addIfNotExist(Collection<E> collection, E value) {
        if (collection.contains(value)) {
            return;
        }
        collection.add(value);
    }
}
