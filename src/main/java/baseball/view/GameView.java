package baseball.view;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void showGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    public void showGameResult(Result result) {
        System.out.println(result.getResult());
    }

    public void showEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
