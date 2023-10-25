package baseball.controller;

import baseball.model.TargetNum;
import baseball.view.Input;
import baseball.view.Output;

public class Game {

    public void run(){
        Hint.isAnswer = false;
        Output.startMessage();

        TargetNum target = new TargetNum();
        int[] targetNum = target.getTarget();

        while(!Hint.isAnswer){
            String userString = Input.userGuess();
            int[] userNum = Input.stringToInt(userString);
            Hint.doBaseBall(targetNum,userNum);
        }

        Output.lastMessage();
    }

}
