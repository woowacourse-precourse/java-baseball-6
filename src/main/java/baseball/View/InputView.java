package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputUserGuess() {
        String userInput = Console.readLine();
        if(!validateUserGuess(userInput)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        return Integer.parseInt(userInput);
    }

}
