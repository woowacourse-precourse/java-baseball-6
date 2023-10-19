package baseball;

import java.util.ArrayList;
import java.util.List;
public class ScoreManager {
    //점수를 올리는 메서드
    //점수를 호가인하는 메서드

    static int BALL;
    static int STRIKE;
    boolean isNothing = true;

        //true : 3스트라이크 아님 vs false : 스트라이트임
    public boolean setAndCheckScore(List<Integer> computer, List<Integer> user){ //점수를저장하고, 점수를 출력함
        //만약 3스트라이크면 최종 출력을 한다.
        BALL = 0;
        STRIKE = 0;
        setScore(computer,user); //두 숫자를 비교하여 점수를 매긴다
        //점수를 출력한다.
        System.out.println(BALL);
        System.out.println(STRIKE);
        return true;
    }

    private void setScore(List<Integer> computer, List<Integer> user){ //두 숫자를 비교하여 점수를 매긴다
        for(Integer userNum : user){
            setBallOrStrike(computer,user,userNum);
        }
    }
    private void setBallOrStrike(List<Integer> computer, List<Integer> user, Integer userNum){
        if(computer.contains(userNum)){
            setStrike(computer,user,userNum);
        }
    }
    private void setStrike(List<Integer> computer, List<Integer> user, Integer userNum){;
        if(computer.indexOf(userNum) == user.indexOf(userNum)){
            STRIKE++;
        }else {
            BALL++;
        }
    }





}
