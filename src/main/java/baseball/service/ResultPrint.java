package baseball.service;

import baseball.dto.Result;

/**
 * 사용자가 숫자를 제시 할 때마다 결과를 출력해 줄 클래스
 */
public class ResultPrint {
    Result result;

    public ResultPrint() {
    }

    public ResultPrint(Result result) {
        this.result = result;
    }

    /**
     * 결과 출력
     */
    public void print() {
        if (result.isStatus() == Result.ANSWER) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result.getBall() == 0) {
            System.out.println(result.getStrike() + "스트라이크");
            return;
        }
        if (result.getStrike() == 0) {
            System.out.println(result.getBall() + "볼");
            return;
        }
        System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
    }
}
