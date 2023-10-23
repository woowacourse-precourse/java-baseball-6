package baseball.controller;
import baseball.models.Score;

import java.util.List;

public class StrikeBallCounter {

    public static void check(List<Integer> computer, List<Integer> user, Score score) {
        countStrikes(computer, user, score);
        countBalls(computer, user, score);
    }
    public static void countStrikes(List<Integer> computer, List<Integer> user, Score score) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            if(isStrike(computer.get(i), user.get(i)))
                cnt++;
        }
        score.setStrikeCnt(cnt);
    }
    public static boolean isStrike(int computerNumber, int userNumber) {
        if(computerNumber == userNumber)
            return true;
        return false;
    }
    public static  void countBalls(List<Integer> computer, List<Integer> user, Score score) {
        int cnt = 0;
        for(int i =0; i < 3; i++){
            if(isBall(computer, user.get(i), i))
                cnt++;
        }
        score.setBallCnt(cnt);
    }
    public static boolean isBall(List<Integer> computer, int userNumber, int currentIndex){
        for(int i = 0; i < 3; i++) {
            if(i == currentIndex)
                continue;
            if(computer.get(i) == userNumber)
                return true;
        }
        return false;
    }
}
