package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    public String readUserInput() {
        return Console.readLine();
    }

    public int getInputNum() {
        int inputNum = Integer.parseInt(Console.readLine());

        return inputNum;
    }

    public List<Integer> parseStringNumbers(String userInput) {

        List<Integer> userInputNumbers = new ArrayList<>();
        for (char digit : userInput.toCharArray()) {
            if (Character.isDigit(digit)) {
                userInputNumbers.add(Integer.parseInt(String.valueOf(digit)));
            } else {
                // 숫자가 아닌 문자를 입력했을 때 예외 처리 로직 추가
                // 유효하지않은 입력에 대한 처리,에러메시지 출력
            }
        }
        return userInputNumbers;
    }
}
