package baseball;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;
public class ScoreManager {
    //점수를 올리는 메서드
    //점수를 호가인하는 메서드

    //MainController mainController = new MainController(); 왜 이걸 치면 안되지?

    static int BALL;
    static int STRIKE;
    boolean isNothing = true;
    boolean isAllStrike = false;

        //true : 3스트라이크 아님 vs false : 스트라이트임
    public boolean setAndCheckScore(List<Integer> computer, List<Integer> user){ //점수를저장하고, 점수를 출력함
        //만약 3스트라이크면 최종 출력을 한다.
        BALL = 0;
        STRIKE = 0;
        setScore(computer,user); //두 숫자를 비교하여 점수를 매긴다
        System.out.println(BALL);
        System.out.println(STRIKE);
        checkAllSolve(); //점수를 출력한다.

        return isAllStrike;
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

    private void checkAllSolve(){
        if(BALL ==0 && STRIKE == 0){
            System.out.println("낫싱");
        } else{
            checkBallOrStrike();
        }
    }
    private void checkBallOrStrike(){
        String str = "";
        if(BALL>0){
            str += BALL+"볼"+" ";
        }
        if(STRIKE>0) { //!!!!!!!!else if로하면 출력이 안되넨???
            if(STRIKE == 3){
                printFinalMsg();
                isAllStrike = true;
            }
            else {
                str += STRIKE+"스트라이크";
            }
        }
        System.out.println(str);
    }

    private void printFinalMsg() {
        System.out.println(STRIKE+"스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }





}
