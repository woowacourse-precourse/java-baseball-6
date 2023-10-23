package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final String START_PROMPT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_PROMPT = "숫자를 입력해주세요 :";

    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int count = 3;

    private Computer computer;

    public GameController() {
        computer = new Computer();
    }

    public void startGame() {

        // 컴퓨터 랜덤 숫자 생성
        List<Integer> randomNumbers = computer.generateRandomNumbers(startInclusive, endInclusive, count);
        // user input 받기
        System.out.println(START_PROMPT);
        String userInput = readUserInput(INPUT_PROMPT);
        List<Integer> userInputNumbers = parseStringNumbers(userInput);

        System.out.println(userInputNumbers);
        System.out.println("randomNumbers = " + randomNumbers);
    }

    public static String readUserInput(String prompt) {
        return Console.readLine();
    }

    public static List<Integer> parseStringNumbers(String Input) {
        String userInput = Console.readLine();

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
