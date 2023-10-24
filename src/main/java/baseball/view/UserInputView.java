package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputView {
    final String InputMessage = "숫자를 입력해주세요 : ";
    List<Integer> userInputList = new ArrayList<>();

    public List<Integer> gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        inputBaseballNumber();
        return userInputList;
    }

    private void inputBaseballNumber() {
        System.out.print(InputMessage);
        verifys(Console.readLine());
    }

    private void verifys(String userInput) {
        verifyValidLength(userInput);
        verifyValidNumber(userInput);
    }

    private void verifyValidLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("길이가 맞지 않습니다." + userInput);
        }
    }

    private void verifyValidNumber(String userInput) {

        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다: " + userInput);
            }
            userInputList.add(Character.getNumericValue(ch));
        }
    }

}
