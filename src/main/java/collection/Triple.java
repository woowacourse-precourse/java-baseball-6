package collection;

import baseball.exception.IndexOutOfBoundsInTripleException;
import baseball.exception.InvalidTripleSizeException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public record Triple<T>(
        T first,
        T second,
        T third
) {
    public static final int MAX_SIZE = 3;

    public static <T> Triple<T> fromSet(final Set<T> set) {
        final List<T> list = set.stream().toList();
        return Triple.fromList(list);
    }

    public static <T> Triple<T> fromList(final List<T> list) {
        validateTripleSize(list);
        return new Triple<>(
                list.get(0),
                list.get(1),
                list.get(2)
        );
    }

    private static <T> void validateTripleSize(final List<T> list) {
        if (list.size() != MAX_SIZE) {
            throw new InvalidTripleSizeException();
        }
    }

    public static <T> Triple<T> of(
            final T first,
            final T second,
            final T third
    ) {
        return new Triple<>(first, second, third);
    }

    public List<T> toList() {
        return List.of(first, second, third);
    }

    public T get(final int index) {
        return switch (index) {
            case 0 -> first;
            case 1 -> second;
            case 2 -> third;
            default -> throw new IndexOutOfBoundsInTripleException();
        };
    }

    public Set<T> toSet() {
        return new LinkedHashSet<>(List.of(first, second, third));
    }

    public boolean contains(final T element) {
        return toList().contains(element);
    }
}

