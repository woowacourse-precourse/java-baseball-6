package baseball;

import java.util.ArrayList;

public class Calculater {

    public static int getBallNum(ArrayList<Integer> answerNum, ArrayList<Integer> userNum){
        int i = 0;

        for(int num :userNum){
            if(answerNum.contains(num) && (answerNum.indexOf(num) != userNum.indexOf(num)))
                i ++;
        }

        return i;
    }

    public static int getStrikeNum(ArrayList<Integer> answerNum, ArrayList<Integer> userNum){
        int i = 0;

        for(int num :userNum){
            if(answerNum.contains(num) && (answerNum.indexOf(num) == userNum.indexOf(num)))
                i ++;
        }

        return i;
    }
}
