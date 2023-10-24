package baseball;

import baseball.computer.Computer;

public class Game {

    private Computer computer;

    //Computer를 주입 받는 생성자
    public Game(Computer computer) {
        this.computer = computer;
    }

    //게임을 시작하고 반복하는 기능
    public void start() {
        while (true) {
            boolean shouldRestartGame = computer.play();
            if (!shouldRestartGame) {
                break;
            }
        }
    }

}
