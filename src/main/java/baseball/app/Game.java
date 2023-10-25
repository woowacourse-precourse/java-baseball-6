package baseball.app;


import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GuideMessage.FINISH_GUIDE;
import static baseball.global.enums.GuideMessage.RESTART_MENU;
import static baseball.global.enums.GuideMessage.START_MENU;
import static baseball.global.util.GameInput.validateMenu;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Round;
import baseball.domain.Player;
import baseball.domain.Computer;
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

        if (finishMenu() == 2) {
            //TODO 종료 메서드 호출
        }

        restart();
    }

    private void showResult() {
        String result = round.getResult();

        if (result.equals(PERFECT.name)) {
            isFinished = true;
            System.out.println(PERFECT.name + "\n" + FINISH_GUIDE.message);
            return;
        }
        isFinished = false;
        System.out.println(result);
    }


    private int finishMenu() {
        while (true) {
            System.out.println(RESTART_MENU.message);
            String s = readLine();
            try {
                menu = validateMenu(s);
                return menu;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void restart() {
        init();
        play();
    }
}
