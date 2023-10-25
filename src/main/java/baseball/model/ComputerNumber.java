package baseball.model;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;
    public ComputerNumber(){
        this.computerNumber=createRandomNumber();
    }
    public List<Integer> createRandomNumber() {//컴퓨터 3자리 자연수 랜덤 생성 메서드
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constants.RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constants.START_RANGE_NUMBER, Constants.END_RANGE_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public List<Integer> getNumbers(){
        return computerNumber;
    }

    public void resetNumber(){
        this.computerNumber=createRandomNumber();
    }
}
