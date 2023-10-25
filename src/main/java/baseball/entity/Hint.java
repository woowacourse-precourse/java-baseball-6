package baseball.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hint {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    private int strikeCnt;
    private int ballCnt;


    public void gamePlay(List<Integer> computerNum, List<Integer> userNum){
        strikeCnt = 0;
        ballCnt = 0;

        // 볼 카운트하기
        Set<Integer> ballCounts = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int nowPcCnt = computerNum.get(i);
            int nowUserCnt = userNum.get(i);

            if(nowUserCnt == nowPcCnt) strikeCnt++;
            ballCounts.add(nowPcCnt);
            ballCounts.add(nowUserCnt);
        }
        ballCnt = 6 - ballCounts.size() - strikeCnt;
    }
}
