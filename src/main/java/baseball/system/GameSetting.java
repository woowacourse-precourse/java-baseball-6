package baseball.system;

import baseball.utils.EqualUtil;

import java.util.ArrayList;

public class GameSetting {
    public static void getGameStatus(ArrayList<Integer> computerNumList, ArrayList<Integer> userNumList){
        int strike = EqualUtil.equalBetweenStrike(userNumList, computerNumList);
        System.out.println("strike: " + strike);
        int ball = EqualUtil.equalBetweenBall(userNumList, computerNumList);
        System.out.println("ball: " + ball);

        getGameHints(strike, ball);
    }

    public static void getGameHints(int strike, int ball){
        if(strike<=0 && ball<=0){
            System.out.println("낫싱");
        }
        if(strike>0){
            System.out.print(strike + "스트라이크 ");
        }
        if(ball>0){
            System.out.println(ball + "볼");
        }
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        }
    }

}
