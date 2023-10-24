package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constants.validLength;

import java.util.ArrayList;
import java.util.List;



public class Computer {
    String number;

    public Computer(){
        this.number = Computer.createNumber();
    }

    public static String createNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < validLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : computer) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

//    public static String createNumber() {
//        List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1, 9, validLength);
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Integer num : numberList) {
//            System.out.println(num);
//            stringBuilder.append(num);
//        }
//        String result = stringBuilder.toString();
//        System.out.println(result);
//        return result;
//    }

    public String play(String userNumber) {
        int cntBS = GameRule.countBallAndStrike(this.number, userNumber);
        int cntS = GameRule.countStrike(this.number, userNumber);
        int cntB = cntBS - cntS;

        return GameRule.hintProvider(cntB, cntS);
    }
}
