package baseball.view;

import baseball.model.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {
    public String getPlayerGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return getPlayerInput();
    }

    public String getPlayerChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getPlayerInput();
    }

    public String getPlayerInput() {
        return Console.readLine();
    }

    public void printGameResult(Score score) {
        StringBuilder sb = new StringBuilder();
        if (score.ball() == 0 && score.strike() == 0) {
            sb.append("낫싱");
        } else {
            if (score.ball() > 0) {
                sb.append(score.ball()).append("볼").append(' ');
            }
            if (score.strike() > 0) {
                sb.append(score.strike()).append("스트라이크");
            }
        }
        System.out.println(sb);
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
