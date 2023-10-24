package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private final String inputNumbers;
    private final List<Integer> numbers;

    public Player(String inputNumbers) {
        this.inputNumbers = inputNumbers;
        this.numbers = new ArrayList<>();
    }

    public void setNumbers() {
        if (this.inputNumbers.length()!=3) {
            throw new IllegalArgumentException();
        }
        try {
            Arrays.stream(this.inputNumbers.split("")).forEach(inputNumber->{
                int number = Integer.parseInt(inputNumber);
                if (this.numbers.contains(number)) {
                    throw new IllegalArgumentException();
                }
                this.numbers.add(number);
            });
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
