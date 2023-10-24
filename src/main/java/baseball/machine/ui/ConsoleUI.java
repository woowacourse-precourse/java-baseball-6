package baseball.machine.ui;

import baseball.machine.count.BallCount;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleUI implements UI {

    @Override
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public String getThreeDigitString() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    @Override
    public void gameResult(BallCount ballCount) {
        if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
            System.out.print("낫싱");
        }
        if (ballCount.getBall() != 0) {
            System.out.print(ballCount.getBall() + "볼 ");
        }
        if (ballCount.getStrike() != 0) {
            System.out.print(ballCount.getStrike() + "스트라이크");
        }
        System.out.println();
    }

    @Override
    public void winGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public String getPostGameAction() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

}
