package baseball.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hint {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    private boolean gameOver = false;

    private int strikeCnt;
    private int ballCnt;


    public void gamePlay(List<Integer> computerNum, List<Integer> userNum){
        gameOver = false;
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

    public void printHint(){
        if(strikeCnt == 0 && ballCnt == 0){
            System.out.println(NOTHING);
        }else if(strikeCnt ==  3){
            System.out.println(strikeCnt + STRIKE);
            gameOver = true;
        }else if(strikeCnt != 0 && ballCnt == 0){
            System.out.println(strikeCnt + STRIKE);
        }else if(strikeCnt == 0 && ballCnt != 0){
            System.out.println(ballCnt + BALL);
        }else if(strikeCnt != 0 && ballCnt != 0){
            System.out.println(strikeCnt + STRIKE + BLANK + ballCnt + BALL);
        }
    }

    public boolean getGameOver(){
        return gameOver;
    }
}
