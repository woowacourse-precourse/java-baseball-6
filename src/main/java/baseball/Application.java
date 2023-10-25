package baseball;

import java.util.List;
;

public class Application {

    static Game game = new Game();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        game.play();

    }

}
