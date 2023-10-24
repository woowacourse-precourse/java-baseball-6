package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isContinue;
        int strike, ball, number;
        int[] computer, user;

        isContinue = true;
        strike = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue) {
            computer = getComputerNumber();

            while (strike != 3) {
                strike = 0;
                ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                number = inputNumber();
                if (number < 100 || number > 999) {
                    throw new IllegalArgumentException();
                }
                user = convertInt2IntArray(number);

                // Count strike
                for (int i = 2; i >= 0; i--) {
                    if (computer[i] == user[i]) {
                        strike += 1;
                        user[i] = 0;
                    }
                }

                // Count ball
                for (int i = 2; i >= 0; i--) {
                    if (user[i] == 0) {
                        continue;
                    }
                    int num = computer[i];
                    if (Arrays.stream(user).anyMatch(n -> n == num)) {
                        ball += 1;
                    }
                }
                printScore(strike, ball);
            }
            isContinue = selectContinuity();
            strike = 0;
        }
    }

    private static boolean selectContinuity() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int isContinue = inputNumber();
        if (isContinue == 1) {
            return true;
        } else if (isContinue == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void printScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static int[] convertInt2IntArray(int number) {
        int[] user = new int[3];

        for (int i = 2; i >= 0; i--) {
            user[i] = number % 10;
            number /= 10;
        }
        return user;
    }

    private static int inputNumber() {
        int number;

        try {
            number = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private static int[] getComputerNumber() {
        int[] computerNumber = new int[3];
        List<Integer> randomList = new ArrayList<>();

        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        for (int i = 2; i >= 0; i--) {
            computerNumber[i] = randomList.get(i);
        }

        return computerNumber;
    }
}
