package baseball;


import baseball.controller.GameController;
import baseball.controller.NumberBaseball;

public class Application {
    public static void main(String[] args) {
        // game 생성
        GameController numberBaseball = NumberBaseball.create();
        // game 실행
        numberBaseball.run();
    }
}
