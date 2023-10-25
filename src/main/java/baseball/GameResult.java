package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameResult {
    private int ball, strike;

    public GameResult() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void showResultNormal() {
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

    // 3스트라이크 일 때
    public int showResultStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        // 사용자 입력 확인
        if (userInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void showResult(List<Integer> computerList, List<Integer> userList) {
        for (int i = 0; i < 3; i++) {
            // 스트라이크
            if (computerList.get(i) == userList.get(i)) {
                strike += 1;
            } else {
                // 볼
                if (computerList.contains(userList.get(i))) {
                    ball += 1;
                }
            }
        }
    }


}