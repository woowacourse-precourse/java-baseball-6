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
        if (user.getStrike() == 0 && user.getBall() == 0) {
            System.out.println("낫싱");
        } else if (user.getStrike() != 0 && user.getBall() != 0) {
            System.out.println(user.getBall() + "볼 " + user.getStrike() + "스트라이크");
        } else if (user.getStrike() == 0 && user.getBall() != 0) {
            System.out.println(user.getBall() + "볼 ");
        } else if (user.getStrike() != 0 && user.getBall() == 0) {
            System.out.println(user.getStrike() + "스트라이크");
            if (user.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return restart.restartOrExit();
            }
        }
        return 3;
    }
}
