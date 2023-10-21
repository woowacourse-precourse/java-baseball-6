package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class BaseballController {

    private final BaseballView view;
    private final BaseballModel model;

    private boolean isPlaying = true;

    public BaseballController(BaseballView view, BaseballModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * 게임 시작
     */
    public void startGame() {
        view.outputStartMessage();
    }

    /**
     * 게임 진행
     */
    public void playGame() {
        isPlaying = true;
        model.chooseRandomNumbers();
        while (isPlaying) {
            view.outputPlayMessage();
            String input = Console.readLine();
            validateInput(input);

            HintResult hintResult = model.getHint(input);
            view.outputHintResultMessage(hintResult);
            if (hintResult.isThreeStrike()) {
                isPlaying = false;
            }
        }
    }

    private void validateInput(String input) {
        validateLength(input);
        validateContainsZero(input);
        validateContainsAlphabetic(input);
        validateDuplicateNumber(input);
    }

    private void validateLength(String input) {
        if (input.length() != BaseballModel.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContainsZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContainsAlphabetic(String input) {
        for (char bit : input.toCharArray()) {
            if (Character.isAlphabetic(bit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicateNumber(String input) {
        HashSet<String> set = new HashSet<>();
        String[] inputNumbers = input.split("");
        for (String inputNumber : inputNumbers) {
            if (!set.add(inputNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
