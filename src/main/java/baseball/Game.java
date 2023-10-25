package baseball;

import java.util.List;

public class Game {
    public static final int ANSWER_SIZE = 3;
    public static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    public static final String RESTART_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String END_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    Player player = new Player();
    Computer computer = new Computer();

    public void startGame() {
        boolean restart = true;
        System.out.println(START_SENTENCE);
        while (restart) {
            play();
            System.out.println(RESTART_SENTENCE);
            restart = player.getRestart();
        }
    }

    public void play() {
        Result result = new Result();
        computer.makeAnswer();
        while (result.getStrike() != ANSWER_SIZE) {
            System.out.println(INPUT_SENTENCE);
            List<Integer> input = player.getInput();
            result = computer.getResult(input);
            System.out.println(result.toString());
        }
        System.out.println(END_SENTENCE);
        computer.makeAnswer();
    }

}
