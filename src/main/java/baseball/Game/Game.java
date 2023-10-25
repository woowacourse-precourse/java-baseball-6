package baseball.Game;

import baseball.Computer.BallCount;
import baseball.Computer.Computer;
import baseball.View.InputView;
import baseball.View.OutputView;

import static baseball.Computer.Computer.*;
import static main.java.baseball.UserValid.Validator.*;

public class Game {
    public static int[] userNumbers;
    public static boolean gameContinue = true;
    public static boolean retryEnd = true;
    //public static void Run(){
    //    Computer.InitGame();
    //    OutputView.printStart();
    //    while(retryEnd){
    //        CreateBall();
    //        checkNum(userNumbers);
    //        endRound();
    //        checkGameEnd();
     //       if(!gameContinue){
      //          int userRetry = InputView.readRetryNumber();
       //         checkRetry(userRetry);
        //    }
       // }
    //}

    public static void CreateBall(String userInputs){

        CheckNumber(userInputs);
        CheckDuplicate(userInputs);
        CheckLength(userInputs);
        userNumbers = userInputs.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void checkGameEnd(){
        if (BallCount.strikeCount == 3){
            gameContinue = false;
            OutputView.printCurrentEnd();
            OutputView.printRetry();
        }
        BallCount.ResetCount();
    }

    public static void checkRetry(int userRetryNum){
        if(userRetryNum==1){
            Computer.InitGame();
            OutputView.printStart();
        }
        else if(userRetryNum == 2){
            retryEnd=false;
        }
    }
}
