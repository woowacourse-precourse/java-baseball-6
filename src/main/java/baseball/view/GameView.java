package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView implements View{
    @Override
    public void showStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    @Override
    public void showGameResult(String result) {
        System.out.println(result);
    }

    @Override
    public void showEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public String inputGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
