package baseball.view;

import baseball.model.Computer;
import baseball.model.User;

public class GameView {

    User user;
    Computer computer;

    public GameView() {
        user = User.getUser();
        computer = Computer.getComputer();
    }

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printInputRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printFinishGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        int ball = user.getBall();
        int strike = user.getStrike();

        if (ball > 0 && strike > 0) {
            sb.append(ball).append("볼").append(' ').append(strike).append("스트라이크");
        } else if (ball > 0) {
            sb.append(ball).append("볼");
        } else if (strike > 0) {
            sb.append(strike).append("스트라이크");
        } else {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}
