package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerBaseballNumber {
    private static final int BASEBALL_INPUT_NUMBER = 3;
    private final List<Integer> baseballNumberList;
    public ComputerBaseballNumber(){
        baseballNumberList = new ArrayList<>();
        while(baseballNumberList.size() < BASEBALL_INPUT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNonDuplicateNumberInList(baseballNumberList, randomNumber);
        }
    }
    private void addNonDuplicateNumberInList(List<Integer> baseballNumberList, int value) {
        if(!baseballNumberList.contains(value)) {
            baseballNumberList.add(value);
        }
    }
    public int get(int digit){
        return baseballNumberList.get(digit);
    }
    public boolean contains(int userInput){
        return baseballNumberList.contains(userInput);
    }


}
