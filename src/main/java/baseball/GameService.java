package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameService {

    public static void run() {
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (game(computer.getGoal())) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Boolean game(int[] computer) {
        int strike = 0, ball = 0;
        System.out.print("숫자를 입력 해 주세요 : ");
        char[] guess = Console.readLine().toCharArray();
        Exception.checkException(guess);
        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(guess[i]);
            if (computer[userNum] == i + 1) {
                strike += 1;
            } else if (computer[userNum] != 0) {
                ball += 1;
            }
        }
        checkResult(strike, ball);
        return strike == 3;
    }

    private static void printResult(CheckResult checkResult, int ball, int strike) {
        switch (checkResult) {
            case NOTHING -> System.out.println("낫싱");
            case BALL -> System.out.println(ball + "볼");
            case STRIKE -> System.out.println(strike + "스트라이크");
            case BALL_AND_STRIKE -> System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    private static void checkResult(int strike, int ball) {
        CheckResult checkResult = CheckResult.NOTHING;
        if (ball != 0) {
            checkResult = checkResult.next(1);
        }
        if (strike != 0) {
            checkResult = checkResult.next(2);
        }
        printResult(checkResult, ball, strike);
    }
}
