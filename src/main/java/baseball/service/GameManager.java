package baseball.service;

import static baseball.util.Message.GAME_EXIT;
import static baseball.util.Message.GAME_RESTART;
import static baseball.util.Message.GAME_START;
import static baseball.util.Message.INPUT_OPTION;
import static baseball.util.Message.INVALID_INPUT;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private final Computer computer;
    private final BaseballService bs;

    public GameManager(Computer computer, BaseballService bs) {
        this.computer = computer;
        this.bs = bs;
    }

    public void startGame() {
        System.out.println(GAME_START);
        bs.getStart(computer);
    }

    public void moreGame() {
        while (true) {
            System.out.println(INPUT_OPTION);
            String coin = Console.readLine();
            String retry = "1";
            String closeGame = "2";
            if (closeGame.equals(coin)) {
                System.out.println(GAME_EXIT);
                break;
            } else if (retry.equals(coin)) {
                System.out.println(GAME_RESTART);
                Computer newComputer = new Computer();
                bs.getStart(newComputer);
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
    }
}
