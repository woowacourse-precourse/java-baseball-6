package baseball.presentation;

import baseball.domain.vo.JudgeResult;

public class BaseballView {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printJudgeResult(JudgeResult judgeResult) {
        System.out.println(getJudgeResultMessage(judgeResult));
    }

    private String getJudgeResultMessage(JudgeResult judgeResult) {
        if(judgeResult.isNothing()) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();

        if(judgeResult.ball() > 0) {
            sb.append(judgeResult.ball()).append("볼 ");
        }

        if(judgeResult.strike() > 0) {
            sb.append(judgeResult.strike()).append("스트라이크");
        }

        return sb.toString();
    }
}
