package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public void run(){
    }

    private List<Integer> inputUserNum(){
        int userInput = Integer.valueOf(Console.readLine());
        List<Integer> userNum = new ArrayList<>();

        while(userInput != 0){
            userNum.add(0, userInput % 10);
            userInput /= 10;
        }
        return userNum;
    }

}
