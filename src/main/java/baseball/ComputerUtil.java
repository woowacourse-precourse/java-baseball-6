package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import static baseball.Constant.*;

public class ComputerUtil {
    private static final Integer NUMBER_COUNT = 3;
    public List<Integer> generateNumber(){
        List<Integer> computerNums = new ArrayList<>();

        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }

    public Boolean compareNumber(List<Integer> computerNums, List<Integer> userNums){
        int ball = 0, strike = 0;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }
            if (computerNums.contains(userNum)) {
                ball++;
            }
        }
        printResultMsg(ball, strike);
        return checkCorrect(strike);
    }

    public void printResultMsg(int ball, int strike){
        String result = "";
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0) {
            result = Integer.toString(ball) + BALL + " ";
        }
        if (strike != 0) {
            result = result + Integer.toString(strike) + STRIKE;
        }
        System.out.println(result);
    }

    public Boolean checkCorrect(int strike){
        int gameControlNum = CONTINUE;
        if (strike == NUMBER_COUNT) {
            System.out.println(CORRECT_MSG);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
