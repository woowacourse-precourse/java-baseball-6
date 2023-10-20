package baseball.service;

import baseball.domain.User;

/**
 * 5. result() : 결과 출력
 */
public class PrintResult {
    private final Restart restart;

    public PrintResult(Restart restart) {
        this.restart = restart;
    }

    public void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    // 0 : 계속 진행, 1 : 재시작, 2 : 종료
    public int result(User user) {
        int strike = user.getStrike();
        int ball = user.getBall();

        String message = generateMessage(strike, ball);
        System.out.println(message);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return restart.restartOrExit();
        }

        return 0;
    }

    private String generateMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼 ";
        } else {
            return strike + "스트라이크";
        }
    }
}
