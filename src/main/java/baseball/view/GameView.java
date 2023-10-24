package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String printGameResult(String hint) {
        System.out.println(hint);
        if (hint.equals("3스트라이크")) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return Console.readLine();
        }
        return "";
    }
}
