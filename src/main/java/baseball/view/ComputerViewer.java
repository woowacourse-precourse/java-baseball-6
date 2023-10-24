package baseball.view;

import baseball.model.Score;

public class ComputerViewer {
    public ComputerViewer() {}

    public void showScore(Score score) {
        StringBuilder result = new StringBuilder();
        int strike = score.getStrike();
        int ball = score.getBall();
        if (ball>0) {
            result.append(ball+"볼 ");
        }
        if (strike>0) {
            result.append(strike+"스트라이크 ");
        }
        if (ball==0 && strike==0) {
            result.append("낫싱");
        }

        System.out.println(result);
    }

    public void showGameWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
