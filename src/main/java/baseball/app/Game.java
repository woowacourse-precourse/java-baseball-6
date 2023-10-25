package baseball.app;


import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GuideMessage.START_MENU;
import static baseball.global.util.GameInput.validateMenu;
import static baseball.global.util.GameOutput.printFinish;
import static baseball.global.util.GameOutput.printRestart;
import static baseball.global.util.GameOutput.printResult;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Round;
import java.util.List;

/**
 * 야구게임 전체적인 로직의 순서와 흐름을 진행하는 Game 클래스
 */
public class Game {

    private Computer computer;
    private Player player;
    private List<Integer> computerNum;
    private List<Integer> playerNum;
    private Round round;
    private boolean isFinished;

    /**
     * 게임 시작을 위해 외부에서 호출할 수 있는 유일한 메서드 (초기와 재시작 시 모두 호출)
     */
    public void start() {
        init();
        play();
    }

    /**
     * 초기화 메서드
     */
    private void init() {
        computer = new Computer();
        System.out.println(START_MENU.message);
        isFinished = true;
    }

    /**
     * 게임의 전반적인 로직이 진행되는 핵심 메서드
     */
    private void play() {
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
        start();   // 재시작
    }

    /**
     * 매 라운드의 결과를 보여주는 메서드
     */
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

    /**
     * 게임이 종료된 후, 재시작 여부를 묻는 메서드
     *
     * @return
     */
    private int finishMenu() {
        while (true) {
            printRestart();
            return validateMenu(readLine());
        }
    }
}
