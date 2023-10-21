package baseball.Controller;

import baseball.model.RandomNumber;
import baseball.model.Retry;
import baseball.model.UserNumber;
import baseball.util.Verification;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static RandomNumber randomNumber;
    private static Verification verification;
    private static UserNumber userNumber;
    private static final String CONTINUE = "1";
    private static final String GAME_END = "2";
    private static List<Integer> count = new ArrayList<>();
    public static void gameStart(){
        BaseballGame();
        retryGame();
    }

    private static void BaseballGame(){
        randomNumber = new RandomNumber();
        verification = new Verification();
         while(!verification.threeStrike()) {
             userNumber = new UserNumber(InputView.userInputNumber());
             count = verification.getCompare(userNumber.getUserNumbers(), randomNumber.getComputerRandomNumber());
             OutputView.ResultView(count.get(0), count.get(1));
         }
        OutputView.gameResultMessage();

    }

    public static void retryGame(){
        Retry retry = new Retry(InputView.Retry());
        if(retry.getRetryNumber().equals(CONTINUE)){
            gameStart();
        }
        if(retry.getRetryNumber().equals(GAME_END)) {
            OutputView.gameEndMessage();
        }
    }
}
