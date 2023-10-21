package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumbers;
    public void generateRandNums(){
        List<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberInList(randomNumberList, randomNumber);
        }
        randomNumbers = randomNumberList;
    }
    private void addNumberInList(List<Integer> randomNumbers, int value) {
        if(!randomNumbers.contains(value)) {
            randomNumbers.add(value);
        }
    }
}
