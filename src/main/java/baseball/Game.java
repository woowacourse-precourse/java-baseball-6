package baseball;

import java.util.List;

public class Game {
    public Game() {
    }

    public void startGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        Number computer = new Number();
        Number player = new Number();

        List<Integer> computerNumber = computer.setRandomNumber();
        // log
        System.out.println("컴퓨터: " + computerNumber);

    }


}
