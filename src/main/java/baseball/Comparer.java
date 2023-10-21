package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparer {

    private final List<Integer> computerNumber;
    private final List<Integer> userNumber;
    private int strike = 0;
    private int ball = 0;



    public Comparer(Computer computer, User user) {
        computerNumber = computer.getComputerNumber();
        userNumber = user.getUserNumber();
    }

    public ArrayList<Integer> compare() {
        ArrayList<Integer> compareResult = new ArrayList<>();
        strike = getStrikeCount();
        ball = getBallCount();
        printRoundResult(strike, ball);
        compareResult.add(strike);
        compareResult.add(ball);
        return compareResult;
    }
    private static void printRoundResult(int strike, int ball) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }
    // Strike 개수 화인
    private int getStrikeCount() {
        for (int i = 0; i < 3; i++) {
            strike += isStrike(i);
        }
        return strike;
    }

    // Ball 개수 확인
    private int getBallCount() {
        for (int i = 0; i < 3; i++) {
            ball += isBall(i);
        }
        return ball;
    }

    private int isStrike(int index) {
        if (computerNumber.get(index) == userNumber.get(index)) {
            return 1;
        }
        return 0;
    }

    private int isBall(int index) {
        int findIdx = userNumber.indexOf(computerNumber.get(index));
        if ( findIdx != -1 && index != findIdx) {
            return 1;
        }
        return 0;
    }
}
