package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private static int[] setting() {
        int order = 1;
        int[] computer = new int[10];
        while (order < 4) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer[randomNum] == 0) {
                computer[randomNum] = order;
                order += 1;
            }
        }
        return computer;
    }

    public static void run() {
        int[] computer = setting();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (game(computer)) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Boolean game(int[] computer) {
        int strike = 0, ball = 0;
        System.out.print("숫자를 입력 해 주세요 : ");
        String guess = Console.readLine();
        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(guess.charAt(i));
            if (computer[userNum] == i + 1) {
                strike += 1;
            } else if (computer[userNum] != 0) {
                ball += 1;
            }
        }
        printResult(strike, ball);
        return strike == 3;
    }

    private static void printResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (ball != 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        System.out.println("낫싱");
    }
}
