package baseball.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameView {

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    /**
     * Veiw는 Model에만 의존해야 하고, Controller에는 의존하면 안된다. Model로 부터 데이터를 받을때는, 사용자마다 다르게 보여주어야하는 데이터에 대해서만 받아야한다. 우리는근데 유저마다
     * 다를게 없기에 의존하지 않는다는 원칙을 따른다.
     */
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallStrikeMessage(List<Integer> ballStrikeCount) {
        if (ballStrikeCount.get(BALL) != 0 && ballStrikeCount.get(STRIKE) == 0) {
            System.out.println(ballStrikeCount.get(BALL) + "볼");
        } else if (ballStrikeCount.get(BALL) != 0 && ballStrikeCount.get(STRIKE) != 0) {
            System.out.print(ballStrikeCount.get(BALL) + "볼 ");
        }

        if (ballStrikeCount.get(STRIKE) != 0) {
            System.out.println(ballStrikeCount.get(STRIKE) + "스트라이크");
        }

        if (ballStrikeCount.get(BALL) == 0 && ballStrikeCount.get(STRIKE) == 0) {
            System.out.println("낫싱");
        }
    }

    public String printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public String printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

}