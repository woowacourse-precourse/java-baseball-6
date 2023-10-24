package baseball.Computer;

import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.View.InputView.readRetryNumber;

public class Computer {
    public static List<Integer> gameNum;
    private final int NashingNum = -1;
    private static int MAX_LEN = 3;
    public static void InitGame(){
        gameNum = new ArrayList<>();
        while (gameNum.size() < 3) {
            int randomNumber =  Randoms.pickNumberInRange(1, 9);
            if (!gameNum.contains(randomNumber)) {
                gameNum.add(randomNumber);
            }
        }
    }

    public static void checkNum(int[] userNums){
        for (int i = 0; i < MAX_LEN; i++) {
            int userNumIndex = i;
            //Integer targetInteger = Integer.valueOf(userNums[i]);
            int gameNumIndex = gameNum.indexOf(userNums[i]);

            if (userNumIndex == gameNumIndex){
                BallCount.Strike();
            }
            else if(gameNumIndex != -1){
                BallCount.Ball();
            }
        }
    }

    public static void endRound() {
        BallCount.Nashing();
        if(!BallCount.Nashing){
            OutputView.printBall(BallCount.ballCount);
            OutputView.printStrike(BallCount.strikeCount);
            BallCount.ResetCount();
        }
    }
}
