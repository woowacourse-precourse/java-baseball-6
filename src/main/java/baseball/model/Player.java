package baseball.model;

import baseball.util.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> playerNumber;

    public Player(String inputNumber){
        String validatedNumber = NumberValidator.getValidatedNumber(inputNumber);
        this. playerNumber = transformPlayerNumber(validatedNumber);
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    private List<Integer> transformPlayerNumber(String validatedNumber) {
        List<Integer> numbers = new ArrayList<>();
        for(char number : validatedNumber.toCharArray()){
            numbers.add(Character.getNumericValue(number));
        }
        return numbers;
    }
}
