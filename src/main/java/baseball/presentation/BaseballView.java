package baseball.presentation;

import baseball.domain.vo.JudgeResult;

public class BaseballView {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printJudgeResult(JudgeResult judgeResult) {
        System.out.println(judgeResult);
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
