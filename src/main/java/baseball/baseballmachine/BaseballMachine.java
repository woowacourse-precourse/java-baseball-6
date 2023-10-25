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

    /* 숫자 야구가 실행되는 메인 함수 */
    public void run() throws IllegalArgumentException {
        computerList = computer.getNewRandomList();
        start = true;
        InputView.printStartMessage();

        while (start) {
            player.init();
            strike = 0;
            ball = 0;

            InputView.printInputRequestMessage();
            playerList = player.inputNumList();

            compareBall();
            printResult();
        }
    }

    private void compareBall() {
        for (int i = 0; i < 3; i++) {
            setStrikeBall(i);
        }
    }

    /* 실제 스트라이크, 볼을 구분하는 메서드 */
    private static void setStrikeBall(int index) {
        if (computerList.get(index).equals(playerList.get(index))) {
            strike++;
        } else if (playerList.contains(computerList.get(index))) {
            ball++;
        }
    }

    /* 스트라이크, 볼에 따른 출력 분기 메서드 */
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

    /* 재시작 여부 체크 */
    private void isRestart() {
        String select = Console.readLine();
        if (select.equals(RESTART)) {
            computer.init();
            computerList = computer.getNewRandomList();
            return;
        } else if (select.equals(EXIT)) {
            start = false;
            return;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.(1 또는 2 입력)");
    }
}
