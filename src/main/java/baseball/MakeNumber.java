package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class MakeNumber {

    public ArrayList<Integer> makeComputerNum() {

        ArrayList<Integer> computer = new ArrayList<>();

        while( computer.size() < 3 ) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if( !computer.contains(randomNum) ) {
                computer.add(randomNum);
            }
        }

        return computer;
    }

    public ArrayList<Integer> makeMynum(String input) {

        ArrayList<Integer> my = new ArrayList<>();

        for( int i = 0; i < 3; i++ ) {
            my.add(Character.getNumericValue(input.charAt(i)));
        }

        return my;
    }
}
