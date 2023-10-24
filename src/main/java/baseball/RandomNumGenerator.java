package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.SystemConstant.GAME_DIGIT;

public final class RandomNumGenerator {

    private  static final int START_INCLUSIVE = 1;
    private  static final int END_INCLUSIVE = 9;

    private RandomNumGenerator() {
    }

    public static List<Integer> generateComputerRandomThreeDigitNumber(){

        List<Integer> computer = new ArrayList<>();
        while(computer.size() <GAME_DIGIT ){
            int randomNumber = makeRandomDigit();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int makeRandomDigit(){
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
