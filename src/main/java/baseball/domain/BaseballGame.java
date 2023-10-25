package baseball.domain;

import static baseball.constant.GameMessage.INPUT_ERROR_MESSAGE;
import static baseball.constant.GameMessage.RESTART_CHECK_MESSAGE;
import static baseball.constant.GameMessage.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private int ballCount;
    private int strikeCount;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void start() {
        System.out.println(START_MESSAGE);
        do {
            play();
        } while (checkRestart());
    }

    public void play() {

    }

    // 게임 재시작 여부를 확인
    public boolean checkRestart() {
        System.out.println(RESTART_CHECK_MESSAGE);
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }
}
