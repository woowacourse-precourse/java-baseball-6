package baseball.view;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class GameService {
    Computer computer = new Computer();
    String userInput;

    public void generateNdigitAnswer(int n) {
        for (int i = 0; i < n; i++) {
            computer.addDigit();
        }
    }

    public void printAnswer() {
        System.out.println(computer.getAnswer());
    }

    public boolean isValidInput(String input) {
        //3자리가 아닌 경우
        if (input.length() != 3) {
            return false;
        }

        boolean isDuplicated[] = new boolean[10];
        Arrays.fill(isDuplicated, false);

        for (int i = 0; i < input.length(); i++) {
            int x = input.charAt(i) - '0';

            //1과 9 사이의 숫자가 아닌 경우
            if (x < 1 || x > 9) {
                return false;
            }

            //서로 다른 숫자가 아닌 경우
            if (isDuplicated[input.charAt(i) - '0']) {
                return false;
            }

            //이미 등장한 숫자임을 표시
            isDuplicated[input.charAt(i) - '0'] = true;
        }

        return true;
    }

    public void getUserInput() {
        String attempt;
        System.out.print("숫자를 입력해주세요 : ");
        attempt = Console.readLine();

        if (!isValidInput(attempt)) {
            throw new IllegalArgumentException();
        }

        this.userInput = attempt;
    }

    public void printUserInput() {
        System.out.println(userInput);
    }

    public static int countBall(String input, String target) {
        int ball = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != target.charAt(i) && (target.contains(input.substring(i, i + 1)))) {
                ball += 1;
            }
        }
        return ball;
    }

    public static int countStrike(String input, String target) {
        int strike = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target.charAt(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public String compare() {
        int ball = countBall(userInput, computer.getAnswer());
        int strike = countStrike(userInput, computer.getAnswer());

        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }

    public void printResult() {
        System.out.println(compare());
    }
}
