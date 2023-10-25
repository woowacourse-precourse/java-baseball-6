package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.OutputView.*;

public class CompareNumber {
    private int strike;
    private int ball;

    public boolean CompareNumber(String userNumber, String computerNumber){
        resetCount();
        String[] userNum = userNumber.split("");
        String[] computerNum = computerNumber.split("");
        List<String> userNumList = new ArrayList<String>(Arrays.asList(userNum));
        List<String> computerNumList = new ArrayList<String>(Arrays.asList(computerNum));

        for(int i = 0; i < userNumList.size(); i++) {
            strikeCount(userNumList.get(i),computerNumList.get(i));
            ballCount(userNumList.get(i), computerNumList, i);
        }
        printStrikeBall();

        if(strike ==3){
            return true;
        }
        return false;
    }

    public void strikeCount(String userNumber, String computerNumber){
        if(userNumber == computerNumber){
            strike++;
        }

    }

    public void ballCount(String userNumber, List<String> computerNumber, int index){
        if(computerNumber.contains(userNumber) && computerNumber.get(index)!=userNumber){
            ball++;
        }
    }

    public void printStrikeBall(){
        if(ball != 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
        if(strike != 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
        if( ball ==0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
        }
    }

    public void resetCount(){
        strike = 0;
        ball = 0;
    }
}
