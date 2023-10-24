package baseball;

import java.util.List;

import baseball.model.RetryGame;
import baseball.model.ComputerNum;
import baseball.model.UserNum;
import baseball.util.DiffNumber;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNum computer = new ComputerNum();
        UserNum user = new UserNum();
        DiffNumber compare = new DiffNumber();
        RetryGame retry = new RetryGame();

        boolean restartGame = true;

        while(restartGame) {
            List<Integer> computerNumber = computer.ComputerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.strikeAndBallCount(computerNumber, user.userNum());
                System.out.println(result);
            }

            restartGame = RetryGame.retryGame();
        }
    }
}