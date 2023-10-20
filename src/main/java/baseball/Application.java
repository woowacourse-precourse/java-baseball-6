package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isAnswer = false;
        while (!isAnswer) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!input.matches("[1-9]{3}")) {
                throw new IllegalArgumentException();
            }
            isAnswer = compare(computer, input);
        }
    }

    private static boolean compare(List<Integer> computer, String input) {

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            String computerNumber = Integer.toString(computer.get(i));
            if (!input.contains(computerNumber)) {
                continue;
            }
            int indexOfInput = input.indexOf(computerNumber);
            if (indexOfInput == i) {
                strike += 1;
            } else {
                ball += 1;
            }
        }
        return printResult(ball, strike);
    }

    private static boolean printResult(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
}
