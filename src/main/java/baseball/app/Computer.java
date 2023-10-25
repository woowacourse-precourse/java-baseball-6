package baseball.app;


import static baseball.global.enums.GameResult.PERFECT;
import static baseball.global.enums.GuideMessage.FINISH_GUIDE;
import static baseball.global.enums.GuideMessage.RESTART_MENU;
import static baseball.global.enums.GuideMessage.START_MENU;
import static baseball.global.util.GameInput.validateMenu;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Baseball;
import baseball.domain.Player;
import baseball.domain.RandomNumber;
import java.util.List;

public class Computer {

    private RandomNumber number;
    private Player player;
    private List<Integer> goal;
    private List<Integer> round;
    private Baseball baseball;
    private boolean isFinished;

    public void init() {
        number = new RandomNumber();
        System.out.println(START_MENU.message);
        isFinished = true;
    }

    public void play() {
        player = new Player();  // 컴퓨터와 대결할 플레이어는 단 1명
        goal = number.make();

        while (true) {
            baseball = new Baseball();
            round = player.start();
            baseball.compare(goal, round);
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
        String result = baseball.getResult();

        if (result.equals(PERFECT.name)) {
            isFinished = true;
            System.out.print(PERFECT.name + "\n" + FINISH_GUIDE.message);
            return;
        }
        isFinished = false;
        System.out.println(result);
    }

    
    private int finishMenu() {
        int menu = 0;

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
