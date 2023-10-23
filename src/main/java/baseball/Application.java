package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static boolean isCharacterExist(String randomNum) {
        try{
            Integer.parseInt(randomNum);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

    public static void main(String[] args) {

        BaseballController baseballController = new BaseballController();
        baseballController.startBaseball();

    }
}
