package baseball;

import java.util.List;
import java.util.ArrayList;
import baseball.computer.Score;
import camp.nextstep.edu.missionutils.*;
import baseball.computer.Util;

public class BaseBall {
    void run() {
        Score score = new Score();
        String ComputerNum = Util.getComputerNum();
        while (score.StrikeNum != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String UserNum = Util.getUserNum();
            score.resetScore();
            score.checkScore(ComputerNum, UserNum);
            score.tellScore();
        }
        askEndOrNot();
    }

    void askEndOrNot() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        Util.checkUserEndNum(choice);
        if (choice == 1) {
            BaseBall newbaseball = new BaseBall();
            newbaseball.run();
        }
    }
}
