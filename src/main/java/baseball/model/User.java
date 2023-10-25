package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    // member variables
    private final List<Integer> numbers;

    // constructor
    public User() {
        this.numbers = new ArrayList<>();
        for(int i = 0;i < 3;i++) this.numbers.add(0);
    }

    // getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumbers(String numbers) {
        for(int i = 0;i < numbers.length();i++){
            char numberChar = numbers.charAt(i);
            Integer numberInt = numberChar - '0';
            this.numbers.set(i, numberInt);
        }
    }
}
