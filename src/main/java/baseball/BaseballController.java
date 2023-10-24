package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class BaseballController {

    private static final String RESTART = "1";
    private static final String END = "2";

    private final BaseballView view;
    private final BaseballModel model;

    private boolean isProgress = false;

    public BaseballController(BaseballView view, BaseballModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * 게임 시작
     */
    public void startGame() {
        isProgress = true;
        view.outputStartMessage();
        while (isProgress) {
            playGame();
            finishGame();
        }
    }

    /**
     * 게임 진행
     */
    private void playGame() {
        boolean isPlaying = true;
        model.chooseRandomNumbers();
        while (isPlaying) {
            view.outputPlayMessage();
            String input = Console.readLine();
            validateBaseballNumbersInput(input);

            HintResult hintResult = model.getHint(input);
            view.outputHintResultMessage(hintResult);
            if (hintResult.isThreeStrike()) {
                isPlaying = false;
            }
        }
    }

    /**
     * 게임 완료 (재시작 또는 종료)
     */
    private void finishGame() {
        view.outputFinishMessage();
        String input = Console.readLine();
        validateFinishInput(input);

        if (input.equals(END)) {
            isProgress = false;
        }
    }

    private void validateBaseballNumbersInput(String input) {
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

    private void validateFinishInput(String input) {
        if (!input.equals(RESTART) && !input.equals(END)) {
            throw new IllegalArgumentException();
        }
    }
}
