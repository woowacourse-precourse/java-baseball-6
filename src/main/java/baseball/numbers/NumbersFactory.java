package baseball.numbers;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Error.*;
import static baseball.constant.Rule.*;

public class NumbersFactory {

    public Numbers createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < SIZE.getValue()) {
            int number = Randoms.pickNumberInRange(START.getValue(), END.getValue());

            if (!computerNumbers.contains(number))
                computerNumbers.add(number);
        }
        return new Numbers(computerNumbers);
    }

    public Numbers createUserNumbers(String input) {
        List<Integer> userNumbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            int number = parseInt(ch);
            userNumbers.add(number);
        }

        return new Numbers(userNumbers);
    }

    private int parseInt(char ch) {
        int number;
        try {
            number = Character.getNumericValue(ch);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_USER_INPUT_NUMBER.getMessage());
        }
        return number;
    }

}
