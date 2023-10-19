package baseball;

import baseball.controller.BaseballController;

public class Application {

    public static void main(String[] args) {
        try {
            new BaseballController().start();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }
}
