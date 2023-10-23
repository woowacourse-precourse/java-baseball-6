package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

    private User user = new User();
    private inputView inputView = new inputView();
    private Count count = new Count();

    private Computer computer = new Computer();
    private List<Integer> BallandStrike = new ArrayList<>();
    private ResultView resultView = new ResultView();
    private GameStatus gameStatus = new GameStatus();


    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setComputerNumber();
        while (gameStatus.getIsGameOnGoing()) {
            user.setUserNumber(inputView.userInput());
            BallandStrike = count.CountcountBallsAndStrikes(user.getUserNumber(), computer.getComputerNumber());
            getResultView(BallandStrike);


        }

    }

    public void getResultView(List<Integer> BallandStrike) {
        if (BallandStrike.get(1) == 3) {
            resultView.ThreeStrike();
            gameStatus.threeStrikeCase(computer);
        }
        if (BallandStrike.get(1) != 3) {
            resultView.printEndMessage(BallandStrike);

        }

    }


}
