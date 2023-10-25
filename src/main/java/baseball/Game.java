package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private static final String RESTART_COMMAND = "1";
    private static final String QUIT_COMMAND = "2";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ANSWER = "3스트라이크";
    private final Computer computer;
    private final Player player;
    private final Referee referee;
    private boolean EXIT = false;

    public Game() {
        computer = new Computer();
        player = new Player();
        referee = new Referee();
    }

    public void run() {
        System.out.println(START_MESSAGE);
        while (!EXIT) {
            play();
        }
    }

    public void play() {
        List<Integer> computerNum = computer.createComputerNum();
        String compareResult = "";
        while (!isAnswer(compareResult)) {
            compareResult = referee.compare(computerNum, player.createUserNum());
            System.out.println(compareResult);
        }
        System.out.println(ANSWER_MESSAGE);
        checkRestart();
    }

    public boolean isAnswer(String compareResult) {
        return compareResult.equals(ANSWER);
    }

    public void checkRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException("1이나 2만 입력할 수 있습니다.");
        }
        if (input.equals(QUIT_COMMAND)) {
            EXIT = true;
        }
    }
}
