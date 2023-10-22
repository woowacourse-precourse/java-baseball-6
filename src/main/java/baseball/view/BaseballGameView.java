package baseball.view;

import baseball.model.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    public BaseballGameView() {

    }

    public void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int readUserInputView() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public boolean showResult(BaseballGame result) {

        if(result.getStrike() == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        if(result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println("낫싱");
            return false;
        }

        if(result.getBall() != 0) {
            System.out.print(result.getBall() + " ");
        }
        if(result.getStrike() != 0) {
            System.out.println(result.getStrike());
        }
        return false;

    }



}
