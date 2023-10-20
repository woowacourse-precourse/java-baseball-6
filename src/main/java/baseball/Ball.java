package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ball {
    /* fields */
    private String ball; // int 보다 String이 게임의 결과를 판단하기 편하다고 생각함

    /* constructors */
    Ball(){
        this.ball = "";
    }
    Ball(String num){
        this.ball = num;
    }

    /* functions */
    // 컴퓨터의 3자리 난수를 생성해서 updateBall() 호출
    public void createRandBall(final int MAXIMUM_NUM, final  int MINIMUM_NUM, final int MAXIMUM_BALL_SIZE){
        String result = "";
        for(int i = 0 ; i < MAXIMUM_BALL_SIZE ; i++){
            result = result + Integer.toString(Randoms.pickNumberInRange(MINIMUM_NUM, MAXIMUM_NUM));
        }
        updateBall(result);
    }
    // updateball 분리한 이유 -> Ball의 필드에 새로운게 추가 될 경우에 업데이트를 전담하게 하기 위해서
    public void createUserBall(String userInput){
        updateBall(userInput);
    }
    public void updateBall(String newBall){
        ball = newBall;
    }
}
