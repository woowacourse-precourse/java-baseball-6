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
    boolean isAllStrike;

        //true : 3스트라이크 아님 vs false : 스트라이트임
    public boolean setAndCheckScore(List<Integer> computer, List<Integer> user){ //점수를저장하고, 점수를 출력함
        //만약 3스트라이크면 최종 출력을 한다.
        BALL = 0;
        STRIKE = 0;
        isAllStrike = false; //얘를 초기화를 했어야해!!!!!!!!

        setScore(computer,user); //두 숫자를 비교하여 점수를 매긴다
        checkAllSolve(); //점수를 출력한다.
        System.out.println(isAllStrike);

        return isAllStrike;
    }

    private void setScore(List<Integer> computer, List<Integer> user){ //두 숫자를 비교하여 점수를 매긴다
        for(Integer userNum : user){
            setBallOrStrike(computer,user,userNum);
        }
    }
    private void setBallOrStrike(List<Integer> computer, List<Integer> user, Integer userNum){
        if(computer.contains(userNum)){ //만약 user의 숫자가 computer숫자에 들어있으면
            setStrike(computer,user,userNum); //ball또는 strike
        }
    }
    private void setStrike(List<Integer> computer, List<Integer> user, Integer userNum){;
        if(computer.indexOf(userNum) == user.indexOf(userNum)){ //만약 같은 숫자가 index도 같으면
            STRIKE++; //=> strike
        }else { //index번호가 다르면 (숫자만 같으면)
            BALL++;  //=>ball
        }
    }

    private void checkAllSolve(){ //3스트라이크인지 확인
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
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); //print로 출력
        //System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }





}
