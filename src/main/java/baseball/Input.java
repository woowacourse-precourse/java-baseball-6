package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.CheckInput.*;

public class Input {
    //종료 여부 결정: 1 -> 재시작, 2 -> 종료
    public static String askRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        return answer.trim();
    }
    //숫자 3개 입력 받는 곳
    public static List<Integer> getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return getInputString();
    }

    //String -> List<Integer>로 변환하기
    private static List<Integer> getInputString() {
        String userInput = Console.readLine();
        String trimInput = userInput.trim();
        validateUserInput(trimInput);
        return inputToInteger(trimInput);
    }

    //String -> Integer List로 변환
    private static List<Integer> inputToInteger(String trimInput) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answer.add(Character.getNumericValue(trimInput.charAt(i)));
        }
        return answer;
    }
}
