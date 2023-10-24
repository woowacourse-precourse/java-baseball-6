package model.player;

import java.util.List;

public abstract class Player {
    protected final List<Integer> numbers;

    protected Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumberByPosition(int position) {
        return numbers.get(position);
    }
}
