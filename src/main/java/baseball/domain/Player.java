package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> elements;

    public Player(List<Integer> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public int getByPosition(int position) {
        return elements.get(position);
    }
}