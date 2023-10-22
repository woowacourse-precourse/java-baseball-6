package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Check {
    Check() {

    }

    void compareNumber(List<Integer> user, List<Integer> computer) { // 사용자와 컴퓨터의 숫자를 비교하는 함수
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (user.get(i) == computer.get(j)) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        if (strike == 0 && ball == 0) {
            nothing++;
        }
        printResult(strike, ball, nothing);
    }

    void printResult(int strike, int ball, int nothing) { // 서로의 숫자를 비교해서 출력하는 함수
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            if (strike == 3) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다!\n" + "게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String number = Console.readLine();

                if (number.equals("1")) {
                    BaseBallGame baseBallGame = new BaseBallGame();
                    baseBallGame.start();
                } else {
                    System.out.print("게임 종료");
                    System.exit(0);
                }
            } else {
                System.out.print(strike + "스트라이크 ");
            }
        }
        if (nothing > 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
