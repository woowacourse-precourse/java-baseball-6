package Model;

import Constant.ExceptionHandling;
import Constant.Ment;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Refree {
    public boolean isStrike(int CurrentNumber, ArrayList<Integer> Numbers, int digit) {
        if (Numbers.get(digit) == CurrentNumber) {
            return true;
        }
        return false;
    }

    public boolean isBall(int CurrentNumber, ArrayList<Integer> Numbers, int digit) {
        for (int i = 0; i < Numbers.size(); i++) {
            if (CurrentNumber == Numbers.get(i)) {
                if (i != digit) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean GameClear(int strike) {
        if (strike == 3) {
            System.out.println(Ment.getMentClear());
            return true;
        }
        return false;
    }
    public boolean GameRestart(){
        int choice=Integer.valueOf(readLine());
        if(choice==1){
            return true;
        }else if(choice==2){
            return false;
        }
        ExceptionHandling.ExceptionNotOneTwo();
        return false;
    }

}
