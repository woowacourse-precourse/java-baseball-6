package baseball;

import baseball.computer.Computer;
import baseball.player.Player;
import baseball.referee.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 게임 시작
        Referee referee = new Referee();
        do {
            // 2. 게임 진행
            referee.askNumber();
            referee.compareNumber();
            referee.getResult();
        }while (referee.getRestart()); // 3. 게임 재시작
    }
}
