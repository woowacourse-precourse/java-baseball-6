package baseball.view;

import baseball.model.Score;

public class BaseballGameView {
    public void showGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showUserInputPrompt() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void showGameResult(Score score) {
        int strikes = score.getStrike();
        int balls = score.getBall();

        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls).append("볼");
        }
        if (strikes > 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }

        if (result.isEmpty()) {
            result.append("낫싱");
        }
        System.out.println(result);
    }

    public void showGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
