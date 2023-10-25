package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private List<Integer> inputBalls;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {

        while (true) {

            receiveInput();

        }
    }

    private void receiveInput() {
        System.out.print("숫자를 입력해주세요: ");
        String balls = Console.readLine();
        checkInput(balls);

        makeInputBalls(balls);
    }

    private void checkInput(String balls) {
        char[] ballsCharArray = balls.toCharArray();
        for (char input : ballsCharArray) {
            isInputNumeric(input);
        }

        checkForDuplicateNumbers(ballsCharArray);
    }

    private void isInputNumeric(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void checkForDuplicateNumbers(char[] ballsCharArray) {
        Set<Character> set = new HashSet<>();
        for (char input : ballsCharArray) {
            set.add(input);
        }

        if (set.size() != ballsCharArray.length) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }

    }

    private void makeInputBalls(String balls) {
        inputBalls = new ArrayList<>();

        for (int i = 0; i < balls.length(); i++) {
            inputBalls.add(balls.charAt(i) - '0');
        }
    }


}
