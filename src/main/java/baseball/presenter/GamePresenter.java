package baseball.presenter;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.HashSet;
import java.util.Set;

public class GamePresenter {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void play() {
        outputView.start();
        startGame();
    }

    private void startGame() {
        outputView.input();
        inputView.inputNumbers();
    }

    public void validateNumbers(String numbers) {
        if (!isValidNumeric(numbers)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        if (!isValidLength(numbers)) {
            throw new IllegalArgumentException("자릿수가 올바르지 않습니다.");
        }
        if (!isDuplicate(numbers)) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    private boolean isValidNumeric(String numbers) {
        return numbers.matches("^[1-9]+$");
    }

    private boolean isValidLength(String numbers) {
        return numbers.length() == 3;
    }

    private boolean isDuplicate(String numbers) {
        Set<Character> uniqueDigits = new HashSet<Character>();
        for (char element : numbers.toCharArray()) {
            uniqueDigits.add(element);
        }
        return uniqueDigits.size() == 3;
    }
}
