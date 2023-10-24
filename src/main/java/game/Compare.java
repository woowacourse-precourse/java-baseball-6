package game;

import static input.Computer.computerNumber;
import static input.User.userNumber;
import static game.Result.printResult;

import java.util.List;

public class Compare {
    private static final int BASEBALL_COUNT = 3;

    private static int countStirke(List<Integer> com, List<Integer> user) {
        int strike = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.get(i) == userNum) {
                strike++;
            }
        }
        return strike;
    }
    private static int countAll(List<Integer> com, List<Integer> user) {
        int all = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.contains(userNum)) {
                all++;
            }
        }
        return all;
    }
    private static boolean isAnswer(int strike) {
        boolean Answer = false;
        if(strike == BASEBALL_COUNT) {
            Answer = true;
        }
        return Answer;
    }
    public static void startCompare() {
        int strike;
        int ball;
        boolean Answer = false;
        List<Integer> comNum = computerNumber();
        while (!Answer) {
            List<Integer> userNum = userNumber();
            strike = countStirke(comNum, userNum);
            ball = countAll(comNum, userNum) - strike;
            printResult(strike, ball);
            Answer = isAnswer(strike);
        }
    }
}
