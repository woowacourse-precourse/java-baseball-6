package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    Computer computer = new Computer();
    Player player = new Player();
    BaseballGame baseballGame = new BaseballGame();

    //게임 시작
    //3스트라이크 될때까지 반복 시키는 애
    //종료, 다시 시작 결정
    public void gameStart() {
        List<Integer> randoms = new ArrayList<>();
        List<Integer> inputs = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        randoms = computer.generateRandomDigits();
        inputs = player.getInput();

        baseballGame.compare(randoms, inputs);
    }
}
