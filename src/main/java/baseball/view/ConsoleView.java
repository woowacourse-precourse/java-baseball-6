package baseball.view;

import baseball.balls.Balls;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {

    @Override
    public String inputString() {
        return Console.readLine();
    }

    @Override
    public void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void displayRequestNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void displayCongratulationMessage() {
        System.out.println(Balls.BALL_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void displayAskRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
