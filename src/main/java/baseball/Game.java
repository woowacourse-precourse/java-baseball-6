package baseball;

import static baseball.constants.Constant.*;

import java.util.List;

public class Game {
    Player player = new Player();
    Computer computer = new Computer();

    public void startGame() {
        System.out.println(START_MESSAGE);
        do {
            run();
            System.out.println(RESTART_MESSAGE);
        } while (player.restart());
    }

    public void run() {
        Score score;
        computer.setComputerNumber();
        do {
            System.out.print(INPUT_MESSAGE);
            List<Integer> input = player.setPlayerNumber();
            score = computer.getScore(input);
            System.out.println(score);
        } while (!score.isThreeStrike());
        System.out.println(FINISH_MESSAGE);
    }
}
