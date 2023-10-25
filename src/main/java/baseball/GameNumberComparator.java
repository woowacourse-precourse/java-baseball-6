package baseball;

import java.util.List;

public class GameNumberComparator {
    public int strike = 0;
    public int ball = 0;
    public void compareNumbers(List<Integer> computerNumber, List<Integer> userNumber){

        int[] computerCount = new int[10];
        int[] userCount = new int[10];

        for (int i = 0; i < 3; i++) {
            computerCount[computerNumber.get(i)]++;
            userCount[userNumber.get(i)]++;
        }
        strike = countStrike(computerNumber, userNumber);

        if (strike < 3) {
            ball = countBall(computerCount, userCount);
        }
    }
    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber){
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            cnt += isEqual(computerNumber.get(i), userNumber.get(i));
        }
        return cnt;
    }
    public static int isEqual(int a, int b){
        if (a == b){
            return 1;
        } else{
            return 0;
        }
    }
    public int countMatchingNumbers(int [] computerCount, int [] userCount){
        int cnt = 0;

        for (int i = 1; i <= 9; i++) {
            cnt += countMatches(computerCount[i], userCount[i]);
        }
        return cnt;
    }
    public int countBall(int [] computerCount, int [] userCount){
        int cnt = countMatchingNumbers(computerCount, userCount);
        return cnt - strike;

    }
    public int countMatches(int computerMatches, int userMatches){
        if (userMatches > 0){
            return computerMatches;
        } else{
            return 0;
        }
    }
}
