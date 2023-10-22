package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInputHandler {
    private boolean checkDigitFromInput() {}
    private boolean checkLengthFromInput() {}
    private boolean isCorrectInput() {}
    public List<Integer> makeUserCount() {}
    public List<Integer> takeInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (!isCorrectInput(userInput)) {
            throw new IllegalArgumentException("입력 오류");
        }
        return makeUserCount();
    }
}
