package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ball {
    /* fields */
    private List<Integer> ball;

    /* functions */
    // 컴퓨터의 3자리 난수를 생성해서 updateBall() 호출
    public void createRandBall(final int MINIMUM_NUM, final  int MAXIMUM_NUM, final int MAXIMUM_BALL_SIZE){
        List<Integer> newBall = new ArrayList<Integer>(MAXIMUM_BALL_SIZE);
        for(int i = 0 ; i < MAXIMUM_BALL_SIZE ; i++){
            newBall.add(createDiffDigit(newBall, MINIMUM_NUM, MAXIMUM_NUM));
        }
        updateBall(newBall);
    }
    // updateball 분리한 이유 -> Ball의 필드에 새로운게 추가 될 경우에 업데이트를 전담하게 하기 위해서
    public void createUserBall(List<Integer> userInput){
        updateBall(userInput);
    }
    private int createDiffDigit(List<Integer> target, final int MAXIMUM_NUM, final int MINIMUM_NUM){
        int newDigit;
        do {
             newDigit = Randoms.pickNumberInRange(MINIMUM_NUM, MAXIMUM_NUM);
        }while(target.contains(newDigit));
        return newDigit;
    }
    private void updateBall(List<Integer> newBall){
        ball = newBall;
    }
}
