package baseball;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private List<Integer> numbers;
    public PlayerNumber(String inputNumber) {
        numbers = new ArrayList<>();
        ExceptionCheck.checkPlayerNumberInput(inputNumber);
        setNumbers(inputNumber);
    }
    private void setNumbers(String input) {
        String[] inputArray = input.split("");
        for (String element : inputArray) {
            int number = Integer.parseInt(element);
            numbers.add(number);
        }
    }
    public int getNumber(int index) {
        return numbers.get(index);
    }
}