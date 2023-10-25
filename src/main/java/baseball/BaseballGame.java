package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {

    private final Number computerNumber;

    public BaseballGame() {
        this.computerNumber = new Number();
    }

    public void play() {
        while (true) {
            List<Integer> userNumbers = getUserInput();
            Result result = checkResult(userNumbers);
            result.display();

            if (result.isGameWon()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return InputValidator.validateAndGet(input);
    }

    private Result checkResult(List<Integer> userNumbers) {
        int strikes = countStrikes(computerNumber.getNumbers(), userNumbers);
        int balls = countBalls(computerNumber.getNumbers(), userNumbers);
        return new Result(strikes, balls);
    }

    private int countStrikes(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < Number.MAX_DIGITS; i++) {
            if (computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBalls(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < Number.MAX_DIGITS; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                count++;
            }
        }
        return count;
    }
}
