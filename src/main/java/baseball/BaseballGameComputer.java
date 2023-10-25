package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BaseballGameComputer {
    private String goalNum;

    public BaseballGameComputer() {
        updateGoalNum();
    }

    private int obtainBallCnt(String userNum) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char comChar = goalNum.charAt(i);
                char userChar = userNum.charAt(j);

                if (i != j && comChar == userChar) {
                    result++;
                }
            }
        }

        return result;
    }

    private int obtainStrikeCnt(String userNum) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char comChar = goalNum.charAt(i);
                char userChar = userNum.charAt(j);

                if (i == j && comChar == userChar) {
                    result++;
                }
            }
        }

        return result;
    }

    public void updateGoalNum() {
        Set<Integer> candidates = new HashSet<>();

        while (candidates.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            candidates.add(randomNumber);
        }

        String result = "";
        Iterator<Integer> iter = candidates.iterator();
        while (iter.hasNext()) {
            Integer next = iter.next();
            result += next;
        }

        goalNum = result;
    }

    public void printResult(String userNum) {
        int ballCnt = obtainBallCnt(userNum);
        int strikeCnt = obtainStrikeCnt(userNum);

        if (ballCnt != 0) {
            System.out.print(ballCnt + "볼 ");
        }

        if (strikeCnt != 0) {
            System.out.print(strikeCnt + "스트라이크 ");
        }

        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

    }

    public boolean isWin(String userNum) {
        if (obtainStrikeCnt(userNum) == 3) {
            return true;
        }
        return false;
    }
}
