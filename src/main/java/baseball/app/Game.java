package baseball.app;


import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GuideMessage.START_MENU;
import static baseball.global.util.GameInput.validateMenu;
import static baseball.global.util.GameOutput.errorMessage;
import static baseball.global.util.GameOutput.printFinish;
import static baseball.global.util.GameOutput.printRestart;
import static baseball.global.util.GameOutput.printResult;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Round;
import java.util.List;

public class Game {

    private Computer computer;
    private Player player;
    private List<Integer> computerNum;
    private List<Integer> playerNum;
    private Round round;
    private boolean isFinished;
    private int menu;

    public void init() {
        computer = new Computer();
        System.out.println(START_MENU.message);
        isFinished = true;
    }

    public void play() {
        player = new Player();  // 컴퓨터와 대결할 플레이어는 단 1명
        computerNum = computer.make();

        while (true) {
            round = new Round();
            playerNum = player.start();
            round.compare(computerNum, playerNum);
            showResult();
            if (isFinished) {
                break;
            }
        }

        printFinish();
        if (finishMenu() == 2) {
            return;
        }

        restart();
    }

    private void showResult() {
        String result = round.getResult();

        if (result.equals(PERFECT.name)) {
            isFinished = true;
            printResult(result);
            return;
        }
        isFinished = false;
        printResult(result);
    }


    private int finishMenu() {
        while (true) {
            printRestart();
            String s = readLine();
            return validateMenu(s);
        }
    }

    private void restart() {
        init();
        play();
    }
}
