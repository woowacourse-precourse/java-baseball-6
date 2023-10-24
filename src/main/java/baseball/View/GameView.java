package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public static String inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

