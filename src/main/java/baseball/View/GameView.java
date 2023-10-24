package baseball.View;

import baseball.Common.Messages;

import java.util.List;

public class GameView {
    public static void printInputRequest(){
        System.out.print(Messages.USER_INPUT_NUMBER);
    }

    public static void printResult(List<Integer> result){
        if(result.get(0) == 3)
            System.out.println(Messages.SUCCESS);
        else if (result.get(0) + result.get(1) == 0)
            System.out.println(Messages.FAIL);
        else
            System.out.println(Messages.STRIKE_AND_BALL(result));
    }
}
