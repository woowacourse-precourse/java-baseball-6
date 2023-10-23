package baseball.domain;

import baseball.constant.Regex;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private final InputView inputView;
    private final OutputView outputView;

    public Player() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public List<Integer> getInputNumber() {
        List<Integer> inputNumbers;
        while (true) {
            outputView.requestNumber();
            String input = inputView.receiveInputNumber();
            if (isValid(input)) {
                inputNumbers = convertStringToList(input);
                break;
            }
        }
        return inputNumbers;
    }

    public int receiveRetryOption() {
        outputView.restartOrQuit();
        int option;
        while (true) {
            String input = inputView.receiveInputNumber();
            if (Regex.ONE_OR_TWO.matches(input)) {
                option = Integer.parseInt(input);
                break;
            }
        }
        return option;
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }
        return inputNumbers;
    }

    private boolean isValid(String input) {
        if (!Regex.ONE_TO_NINE.matches(input) || !hasNoDuplicateDigits(input)) {
//            outputView.printMessage("비정상적인 입력입니다. 게임이 종료됩니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }


    private boolean hasNoDuplicateDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            uniqueDigits.add(digit);
        }
        return uniqueDigits.size() == input.length();
    }
}