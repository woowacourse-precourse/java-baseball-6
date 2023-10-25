package baseball.model;

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
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
