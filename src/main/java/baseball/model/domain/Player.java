package baseball.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers;

    public Player(String inputNumbers) {
        this.playerNumbers = convertNumbers(inputNumbers);
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public List<Integer> convertNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            char ch = inputNumbers.charAt(i);
            int num = Character.getNumericValue(ch);
            numbers.add(num);
        }
        return numbers;
    }

}
