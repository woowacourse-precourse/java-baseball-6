package baseball.Computer;

import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    //public static List<Integer> gameNum;
    private static final int MAX_LEN = 3;
    public static List<Integer> InitGame(){
        List<Integer> gameNum = new ArrayList<>();
        while (gameNum.size() < 3) {
            int randomNumber =  Randoms.pickNumberInRange(1, 9);
            if (!gameNum.contains(randomNumber)) {
                gameNum.add(randomNumber);
            }
        }
        return gameNum;
    }

    public static void checkNum(List<Integer> ComputerNum ,int[] userNums){
        for (int i = 0; i < MAX_LEN; i++) {
            int gameNumIndex = ComputerNum.indexOf(userNums[i]);

            if (i == gameNumIndex){
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
        }
        System.out.print('\n');
    }
}
