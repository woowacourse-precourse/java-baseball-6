package baseball.baseballmachine;

import baseball.computer.Computer;
import baseball.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballMachine {
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private static int strike;
    private static int ball;
    private static List<Integer> computerList;
    private static List<Integer> playerList;
    private static boolean start;

    private final Computer computer;
    private final Player player;

    public BaseballMachine(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void run() throws IllegalArgumentException {
        computerList = computer.createRandomList();
        start = true;
        InputView.printStartMessage();

        while (start) {
            player.initPlayer();
            strike = 0;
            ball = 0;

            InputView.printInputRequestMessage();
            playerList = player.inputNum();

            compareBall();
            printResult();
        }
    }

    private void compareBall() {
        for (int i = 0; i < 3; i++) {
            checkLogic(i);
        }
    }

    private static void checkLogic(int index) {
        if (computerList.get(index).equals(playerList.get(index))) {
            strike++;
        } else if (playerList.contains(computerList.get(index))) {
            ball++;
        }
    }

    private void printResult() {
        /* 낫싱 */
        if (strike == 0 && ball == 0) {
            OutputView.printNothing();
            return;
        }

        /* strike 3개일 경우 */
        if (strike == 3) {
            OutputView.printStrike(strike);
            OutputView.printSuccessMessage();
            InputView.printRestartMessage();
            isRestart();
            return;
        }

        if (strike >= 1 && ball >= 1) {
            OutputView.printStrikeBall(strike, ball);
            return;
        }

        if (strike == 0 && ball >= 1) {
            OutputView.printBall(ball);
            return;
        }

        if (strike >= 1 && ball == 0) {
            OutputView.printStrike(strike);
        }
    }

    private void isRestart() {
        String select = Console.readLine();
        if (select.equals(RESTART)) {
            computer.initComputerList();
            computerList = computer.createRandomList();
            return;
        } else if (select.equals(EXIT)) {
            start = false;
            return;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.(1 또는 2 입력)");
    }
}
