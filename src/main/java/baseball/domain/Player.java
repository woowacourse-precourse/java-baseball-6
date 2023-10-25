package baseball.domain;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.logic.BaseballGame.EXIT;
import static baseball.logic.BaseballGame.RESTART;

public class Player {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Player() {
        this.numbers = new ArrayList<>();
    }
    public void guessNumbers() {
        String inputNumbers = InputView.inputNumbers();
        if(inputNumbers.length() <= 0 || inputNumbers.length() > 3 || isThereDuplicateNumber(inputNumbers)){
            throwIllegalArgumentException();
        }
        numbers.clear();
        for (int i = 0; i < 3; i++) {
            numbers.add(inputNumbers.charAt(i) - '0');
        }
    }

    public String replayOrExit() {
        String answer = InputView.inputReplayOrExit();
        if (answer.equals(RESTART) || answer.equals(EXIT)) {
            return answer;
        }
        throwIllegalArgumentException();
        return null;
    }

    // 사용자의 입력에 중복 숫자가 있는지 검사한다
    public boolean isThereDuplicateNumber(String guess) {
        String temp = "";

        for (char guessNumber: guess.toCharArray()) {
            if (!temp.contains(String.valueOf(guessNumber))) {
                temp += String.valueOf(guessNumber);
            } else {
                return true;
            }
        }

        return false;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }
}
