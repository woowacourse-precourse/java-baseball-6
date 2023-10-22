package baseball.service;

import baseball.util.ExceptionHandler;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballService {
    private final InputView inputView = new InputView();
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void baseballGameStart(List<Integer> integerList) {
        boolean isDifferent = true;
        while (isDifferent) {
            String input = inputView.getInput();
            isValidNumber(input);
        }
    }

    private void isValidNumber(String str) {
        if (isThreeDigits(str) && hasNoZero(str) && hasUniqueDigits(str)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isThreeDigits(String str) {
        return str.length() == 3;
    }

    private boolean hasNoZero(String str) {
        return !str.contains("0");
    }

    public boolean hasUniqueDigits(String str) {
        char[] digits = str.toCharArray();
        Set<Character> uniqueSet = new HashSet<>();

        for (char digit : digits) {
            if (uniqueSet.contains(digit)) {
                return false;
            }
            uniqueSet.add(digit);
        }
        return true;
    }

}
