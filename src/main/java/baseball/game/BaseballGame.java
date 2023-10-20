package baseball.game;

import java.util.List;

public class BaseballGame {
    /**
     * 컴퓨터 숫자와 사용자 입력 숫자를 비교한다.
     * @param computers 컴퓨터 랜덤 숫자
     * @param players 사용자 입력 숫자
     */
    public static void compare(List<Integer> computers, List<Integer> players) {
        int strike = 0;
        int duplicateCount = 0;
        int ball;

        //각 자리수별로 일치한지
        for (int i = 0; i < 3; i++) {
            if (computers.get(i) == players.get(i)) {
                strike++;
            }
            if (players.contains(computers.get(i))) {
                duplicateCount++;
            }
        }

        ball = duplicateCount - strike;
        printCompare(strike, ball);
    }

    /**
     * 비교한 결과를 출력한다.
     * @param strike 스크라이크의 개수
     * @param ball 볼의 개수
     */
    public static void printCompare(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println("");
    }
}
