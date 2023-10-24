package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final int ANSWER_DIGIT = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private static Map<Integer, Integer> answer;
    private int strikeCnt;
    private int ballCnt;

    public Computer(){
    }

    public void makeRandomAnswer(){
        answer = new HashMap<>();
        int order = 0;

        while(answer.size() < ANSWER_DIGIT){
            int randomNum = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);

            if(!answer.containsKey(randomNum)){
                answer.put(randomNum, order);
                order++;
            }
        }
    }

    public void calculateScore(List<String> playerInput){
        initializeScore();

        for(int i=0;i<ANSWER_DIGIT;i++) {
            int userNum = Integer.parseInt(playerInput.get(i));
            if(!answer.containsKey(userNum)){
                continue;
            }

            if(answer.get(userNum) == i){
                strikeCnt++;
                continue;
            }

            ballCnt++;
        }
    }

    private void initializeScore(){
        strikeCnt = 0;
        ballCnt = 0;
    }

    public String makeResultMessage(){
        String result = "";

        if(strikeCnt == 0 && ballCnt == 0){
            return NOTHING;
        }

        if(ballCnt > 0){
            result += (ballCnt + BALL + " ");
        }

        if(strikeCnt > 0){
            result += (strikeCnt + STRIKE);
        }

        return result.trim();
    }

    public boolean isPlayerWin(){
        return strikeCnt == ANSWER_DIGIT;
    }
}
