package baseball;

import java.util.List;

public class Game {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_MESSAGE = "숫자를 입력하세요 : ";
    public static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

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
