package baseball.domain;

import baseball.validation.CheckGameNumbers;
import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> inputNums;

    public Player(String input) {
        CheckGameNumbers checkInput = new CheckGameNumbers();
        checkInput.checkValidationOfNums(input);

        inputNums = stringToList(input);
    }

    public List<Integer> getInputNums() {
        return inputNums;
    }


    List<Integer> stringToList(String in) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < in.length(); i++) {
            numbers.add(Character.getNumericValue(in.charAt(i)));
        }
        return numbers;
    }
}
