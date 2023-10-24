package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers;
    public Player() {
        numbers = new ArrayList<>();
    }
    public void setNumber(List<Integer> new_numbers) {
        numbers.clear();
        while (numbers.size() < 3) {
            numbers.add(new_numbers.get(numbers.size()));
        }
    }
    public int getNumber(int index) { return numbers.get(index); }
}
