package baseball.domain;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private InputValidator inputValidator = new InputValidator();
    public List<Integer> getPlayerNumbers() {
        List<Integer> playerNumbers = new ArrayList<>();
        String input = Console.readLine();
        if (!inputValidator.isValidNumbersInput(input)) {
            throw new IllegalArgumentException();
        }
        playerNumbers = convertInputToNumbers(input);
        return playerNumbers;
    }

    public int getFinishInput() {
        String input = Console.readLine();
        if (!inputValidator.isValidFinishInput(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private List<Integer> convertInputToNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        String[] inputArr = input.split("");
        for (String tmp : inputArr) {
            playerNumbers.add(Integer.parseInt(tmp));
        }
        return playerNumbers;
    }
}