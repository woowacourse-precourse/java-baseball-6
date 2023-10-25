package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String running = "1";
        while (running.equals("1")) {
            GameStart();
            running = isRestart();
        }
    }

    public static void GameStart() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("숫자 야구 게임을 시작합니다.");
        String input_value;
        int strike = 0;
        int ball = 0;
        List<Integer> user = new ArrayList<>();

        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            input_value = Console.readLine();
            isRightInput(input_value);
            strike = 0;
            ball = 0;
            for (int i = 0; i < 3; i++) {
                int computer_value = computer.get(i);
                for (int j = 0; j < 3; j++) {
                    int player_value = Character.getNumericValue(input_value.charAt(j));
                    if (computer_value == player_value) {
                        if (i == j) {
                            strike += 1;
                        } else {
                            ball += 1;
                        }
                    }

                }
            }
            displayResult(strike, ball);
        }
    }

    public static void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static String isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void isRightInput(String input) {
        try {
            checkisNumber(input);
            checkLength(input);
            checkSameNumber(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void checkisNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (!Character.isDigit(tmp)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkSameNumber(String input) {
        char a = input.charAt(0);
        char b = input.charAt(1);
        char c = input.charAt(2);
        if (a == b | a == c | b == c) {
            throw new IllegalArgumentException();
        }

    }

    public static void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
