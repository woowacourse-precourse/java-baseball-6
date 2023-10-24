package baseball.view;

import baseball.utils.Constants;

public class OutputView {
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void isContinue(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 " + Constants.RETRY + ", 종료하려면 " + Constants.EXIT + "를 입력하세요.");
    }

    public void exitGame(){
        System.out.println("게임 종료");
    }

    public void inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }
}
