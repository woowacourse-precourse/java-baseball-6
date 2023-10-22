package baseball.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;
import java.util.stream.IntStream;

public class InputView {

    public String inputUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine().trim();
        if(!validateUserGuess(userInput)) { throw new IllegalArgumentException(); };

        return userInput;
    }

    public String inputQuitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine().trim();
        try {
            validateQuitOrRestart(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 입력입니다.");
        }
        return userInput;
    }

    private boolean validateUserGuess(String userInput) {
        return validateInputSize(userInput) && validateInputCondition(userInput);
    }

    private boolean validateInputCondition(String userInput) {
        IntStream userStream = userInput.chars();
        return userStream.filter(i -> i > '0' && i <= '9')
                .distinct()
                .count() == 3;
    }

    private boolean validateInputSize(String userInput) {
        return userInput.length() == 3;
    }

    public void validateQuitOrRestart(String userInput) throws IllegalArgumentException {
        if(!Objects.equals(userInput, InputValidationConstant.RESTART) && !Objects.equals(userInput, InputValidationConstant.QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
