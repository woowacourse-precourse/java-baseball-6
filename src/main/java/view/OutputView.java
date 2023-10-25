package view;

import computer.Hint;

public class OutputView {
    public void viewHint(){
        Hint hint = Hint.getInstance();
        if (hint.loadBall() != 0 && hint.loadStrike() != 0) {
            System.out.println(hint.loadBall() + "볼 " + hint.loadStrike() + "스트라이크");
            return;
        }
        if (hint.loadBall() != 0 && hint.loadStrike() == 0) {
            System.out.println(hint.loadBall() + "볼");
            return;
        }
        if (hint.loadBall() == 0 && hint.loadStrike() != 0) {
            System.out.println(hint.loadStrike() + "스트라이크");
            return;
        }
        if (hint.loadBall() == 0 && hint.loadStrike() == 0) {
            System.out.println("낫싱");
        }
    }

    public void viewGameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
