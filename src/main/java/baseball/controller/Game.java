package baseball.controller;

import baseball.model.TargetNum;
import baseball.view.Input;

public class Game {

    TargetNum target;

    String userString ="";


    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        target = new TargetNum();
        int[] targetNum = target.getTarget();

        while(Hint.isAnswer != true){

        userString = Input.userGuess();
        int[] userNum = Input.stringToInt(userString);
        Hint.doBaseBall(targetNum,userNum);

        }

    }

}
