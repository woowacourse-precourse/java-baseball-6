package baseball;

import java.util.List;

public class Game {
    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run(){
        Computer computer = new Computer();
        Player player = new Player();

        List<Integer> hintValues = computer.compareTargetNumbers(player.getNumbers());

    }

}
