package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        boolean gameContinue = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameContinue) {
            List<Integer> computer = new ArrayList<>();
            List<Integer> myDigit = new ArrayList<>();
            int inputDigit;
            boolean correctComputerDigit = false;

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (!correctComputerDigit) {
                String input;
                int divideValue = 100;

                System.out.print("숫자를 입력해주세요 : ");
                input = Console.readLine();
                inputDigit = Integer.parseInt(input);

                while (inputDigit != 0) {
                    myDigit.add(inputDigit / divideValue);
                    inputDigit %= divideValue;
                    divideValue /= 10;
                }

                if (input.length() != 3 || !checkThreeDifferentDigit(myDigit)) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨어요.");
                }

                correctComputerDigit = check3Strike(calculateBallAndStrike(computer, myDigit));
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int gameContinueValue = Integer.parseInt(Console.readLine());
            if (gameContinueValue != 1) {
                gameContinue = false;
            }
        }
    }

    private static boolean checkThreeDifferentDigit(List<Integer> myDigit) {
        for (int i = 0; i < myDigit.size() - 1; i++) {
            for (int j = i + 1; j < myDigit.size(); j++) {
                if (Objects.equals(myDigit.get(i), myDigit.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int calculateBallAndStrike(List<Integer> com, List<Integer> myDigit) {

        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(com.get(i), myDigit.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                    break;
                }
            }
        }
        myDigit.clear();

        printCalcResult(ball, strike);

        return strike;
    }

    private static void printCalcResult(int ball, int strike) {

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike != 0) {
            System.out.print(ball + "볼 ");
        } else {
            System.out.println(ball + "볼");
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    private static boolean check3Strike(int strike) {
        return strike == 3;
    }
}
