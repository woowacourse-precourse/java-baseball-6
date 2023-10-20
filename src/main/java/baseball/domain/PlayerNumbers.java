package baseball.domain;

import baseball.resource.GameMessage;
import baseball.validator.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers {

    private List<Integer> numbers;

    public PlayerNumbers() {
        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        InputValidation.isNull(inputNumber);
        InputValidation.isNumber(inputNumber);
        InputValidation.isThreeLetter(inputNumber);
        InputValidation.isNumberScope(inputNumber);
        InputValidation.isDuplicateNumber(inputNumber);

        this.numbers = changeInputStringToNumber(inputNumber);
    }

    private List<Integer> changeInputStringToNumber(String inputNumber) {
        List<Integer> changeList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            changeList.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return changeList;
    }
}
