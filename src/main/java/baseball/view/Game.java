package baseball.view;

import baseball.func.BallCount;
import baseball.func.MakeComputerNumber;
import baseball.func.MakePlayerNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private final MakePlayerNumber makePlayerNumber;
    private final MakeComputerNumber makeComputerNumber;
    private final BallCount ballCount;

    public Game() {
        this.makePlayerNumber = new MakePlayerNumber();
        this.makeComputerNumber = new MakeComputerNumber();
        this.ballCount = new BallCount();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber = makeComputerNumber.copmputerNumber();
        goGame(computerNumber);
    }

    public void goGame(List<Integer> computerNumber) {
        while (true) {
            int[] playerNumber = makePlayerNumber.getPlayerNumber();
            boolean gameEnded = ballCount.userCount(playerNumber, computerNumber);

            if (gameEnded) {
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
                String choice = Console.readLine();

                if ("1".equals(choice)) {
                    computerNumber = makeComputerNumber.copmputerNumber();
                } else if ("2".equals(choice)) {
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    System.out.println("올바른 선택이 아닙니다. 1 또는 2를 입력하세요.");
                }
            }
        }
    }

}
