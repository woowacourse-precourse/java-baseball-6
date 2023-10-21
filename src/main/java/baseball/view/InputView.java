package baseball.view;

import baseball.util.GameInputValidator;
import baseball.util.ReStartInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 메서드 네임 리팩토링 필요
    public void showGameStartMent() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int readNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String gameInputNum = Console.readLine();
        new GameInputValidator().validate(gameInputNum);
        return Integer.parseInt(gameInputNum);
    }

    public int readNumOfReGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reStartInputNum = Console.readLine();
        new ReStartInputValidator().validate(Console.readLine());
        return Integer.parseInt(reStartInputNum);
    }


}
