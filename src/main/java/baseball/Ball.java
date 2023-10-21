package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ball {
    /* fields */
    private static final int MINIMUM_NUM = 1;
    private static final int MAXIMUM_NUM = 9;
    private static final int MAXIMUM_BALL_SIZE = 3;
    private List<Integer> ball;

    /* functions */
    // 컴퓨터의 3자리 난수를 생성해서 updateBall() 호출
    public void createRandBall(){
        List<Integer> newBall = new ArrayList<Integer>(MAXIMUM_BALL_SIZE);
        for(int i = 0 ; i < MAXIMUM_BALL_SIZE ; i++){
            newBall.add(createDiffDigit(newBall));
        }
        updateBall(newBall);
    }

    public void createUserBall(List<Integer> userInput){
        updateBall(userInput);
    }
    private int createDiffDigit(List<Integer> target){
        int newDigit;
        do {
             newDigit = Randoms.pickNumberInRange(MINIMUM_NUM, MAXIMUM_NUM);
        }while(target.contains(newDigit));
        return newDigit;
    }
    // updateball 분리한 이유 -> Ball의 필드에 새로운게 추가 될 경우에 업데이트를 전담하게 하기 위해서
    private void updateBall(List<Integer> newBall){
        ball = newBall;
    }
    public int countStrike(Ball userBall){
        int strikeCount = 0;
        for(int i = 0 ; i < MAXIMUM_BALL_SIZE ; i++){
            if(userBall.ball.get(i) == this.ball.get(i)) strikeCount++;
        }
        return strikeCount;
    }
    public int countBall(Ball userBall){
        int ballCount = 0;
        for(int i = 0 ; i < MAXIMUM_BALL_SIZE ; i++){
            if((userBall.ball.get(i) != this.ball.get(i)) && this.ball.contains(userBall.ball.get(i))) ballCount++;
        }
        return ballCount;
    }
    // getter 추가
    public static int getMaximumBallSize(){
        return MAXIMUM_BALL_SIZE;
    }
}
