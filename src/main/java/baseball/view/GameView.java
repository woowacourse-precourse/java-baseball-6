package baseball.view;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Console;

public class GameView implements View{
    public void showStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    public void showGameResult(Result result) {
        System.out.println(result.getResult());
    }

    public void showEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String inputGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
