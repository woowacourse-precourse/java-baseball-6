package baseball.view;

import camp.nextstep.edu.missionutils.Console;


public class BaseBallView {
    public void startBaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void outputResult(String str) {
        System.out.println(str);
    }

    public String endGame() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
