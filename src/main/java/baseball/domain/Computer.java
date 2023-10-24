package baseball.domain;


import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.app.Baseball;
import baseball.global.enums.GameResult;
import baseball.global.enums.GuideMessage;
import java.util.List;

public class Computer {

    private RandomNumber number;
    private int status;  // 라운드 진행 상태 (1: 진행중, 2: 종료)

    public Computer() {
        status = 1;  // 객체 생성과 동시에 라운드는 진행상태(1)가 된다
    }

    public void init() {
        number = new RandomNumber();
        System.out.println(GuideMessage.START_MENU.message);
    }

    public void play() {
        Player player = new Player();
        Baseball baseball = new Baseball();
        List<Integer> goal = number.make();

        while (status == 1) {
            List<Integer> round = player.start();
            baseball.compare(goal, round);
            String result = baseball.getResult();

            if (result.equals(GameResult.PERFECT.name)) {
                System.out.print(GameResult.PERFECT.name + "\n" + GuideMessage.FINISH_GUIDE.message);
                break;
            }
            System.out.println(result);
        }

        while (status == 1) {
            System.out.println(GuideMessage.RESTART_MENU.message);
            int menu;
            menu = Integer.parseInt(readLine());
            if (menu != 1 && menu != 2) {
                throw new IllegalArgumentException("1(재시작) 또는 2(종료)만 입력해주세요.");
            }
            if (menu == 2) {
                status = 2;
                //TODO 종료 메서드 호출
            }
            if (menu == 1) {
                init();
                play();
            }

        }

    }


}
