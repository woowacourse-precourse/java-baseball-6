package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static List<Integer> computerNumber;
    final static int randomRangestart=0;
    final static int randomRangeend=9;
    final static int listSize=3;

    public static void generateRandomNumber(){
        List<Integer> tempComputerNumber = new ArrayList<>();
        while (tempComputerNumber.size() < listSize) {
            int randomNumber = Randoms.pickNumberInRange(randomRangestart, randomRangeend);
            if (!tempComputerNumber.contains(randomNumber)) {
                tempComputerNumber.add(randomNumber);
            }
        }
        computerNumber=tempComputerNumber;
    }
}
