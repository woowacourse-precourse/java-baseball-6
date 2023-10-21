package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {
    public ArrayList<Integer> computerNumber;
    public ArrayList<Integer> userNumber;
    int ball;
    int strike;
    Baseball() {

    }
    public void resetComputerNumber() {
        computerNumber = new ArrayList<Integer>();
        while(computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber))
                computerNumber.add(randomNumber);
        }
    }

    public void resetUserNumber(String inputNumber) throws InputNumberException {
        userNumber = new ArrayList<Integer>();
        String[] inputNumberArray = inputNumber.split("");
        for(String s : inputNumberArray) {
            int addNumber = Integer.valueOf(s).intValue();
            // 입력 예외 처리
            if(userNumber.contains(addNumber) || userNumber.size() + 1 > 3) {
                throw new InputNumberException();
            }
            userNumber.add(addNumber);
        }
    }
}
