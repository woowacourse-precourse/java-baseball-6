package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printExitGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

}
