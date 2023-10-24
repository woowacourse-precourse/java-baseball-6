package baseball.Game;

import baseball.Computer.BallCount;
import baseball.Computer.Computer;
import baseball.View.InputView;
import baseball.View.OutputView;

import static baseball.Computer.Computer.*;
import static main.java.baseball.UserValid.Validator.*;

public class Game {
    private static int[] userNumbers;
    private static boolean gameContinue = true;
    public static void Run(){
        Computer.InitGame();
        OutputView.printStart();
        while(gameContinue){
            CreateBall();
            checkNum(userNumbers);
            endRound();
            checkEnd();
            BallCount.ResetCount();
        }
        OutputView.printEnd();
        OutputView.printRetry();
        InputView.readRetryNumber();
    }

    public static void CreateBall(){
        OutputView.printInput();
        String userInputs = InputView.readGameNumber();
        CheckNumber(userInputs);
        CheckDuplicate(userInputs);
        CheckLength(userInputs);
        userNumbers = userInputs.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void checkEnd(){
        if (BallCount.strikeCount == 3){
            gameContinue = false;
            BallCount.ResetCount();
        }
    }
}
