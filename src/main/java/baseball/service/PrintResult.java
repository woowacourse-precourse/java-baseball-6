package baseball.service;

import baseball.domain.User;

/**
 * 5. result() : 결과 출력
 */
public class PrintResult {

    public void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public boolean result(User user) {
        int strike = user.getStrike();
        int ball = user.getBall();

        String message = generateMessage(strike, ball);
        System.out.println(message);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }

        return false;
    }

    private String generateMessage(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return "낫싱";
        }

        return generateScore(strike, ball);
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private String generateScore(int strike, int ball) {
        StringBuilder score = new StringBuilder();

        if (ball != 0) {
            score.append(ball).append("볼 ");
        }

        if (strike != 0) {
            score.append(strike).append("스트라이크");
        }

        return score.toString().trim();
    }
}
