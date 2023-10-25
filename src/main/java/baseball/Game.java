package baseball;

import baseball.util.OutputUtil;

import static baseball.Constant.*;
import static baseball.Constant.IS_CONTINUE_FLAG;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    Computer computer = new Computer();
    User user = new User();
    Referee referee = new Referee();

    public Game() {
    }

    public void endGame() {
        System.out.println(END_GAME);
    }

    public void startGame() {
        String baseballNum = computer.createValidBaseballNum();
        playGame(baseballNum);
    }

    private void playGame(String baseballNum) {
        while (true) {
            String userNum = user.getNum();
            Score score = referee.judgeScore(baseballNum, userNum);
            OutputUtil.printScore(score);
            if (Referee.isGameEnd(score)) {
                break;
            }
        }
        continueGame();
    }

    public void continueGame() {
        System.out.println(END_GAME_MENT);
        System.out.println(NEW_GAME_MENT);
        String flag = readLine();
        if (flag.equals(IS_CONTINUE_FLAG)) {
            startGame();
            return;
        }
        endGame();
    }
}
