package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private static final int defaultDigitalCount = 3;
    private static final int minimumCanCreatedValue = 1;
    private static final int maximumCanCreatedValue = 9;
    private ArrayList<Integer> numberList;

    public Computer() {
        this.numberList = generateRandomNumberListWithNotRepeating();
    }
    public Computer(int digitCount) {
        this.numberList = generateRandomNumberListWithNotRepeating(digitCount);
    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(){
        return generateRandomNumberListWithNotRepeating(defaultDigitalCount);
    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(int digitCount){

        var randomNumberList = new ArrayList<Integer>();

        while (randomNumberList.size()<digitCount){
            int randomNumber = Randoms.pickNumberInRange(minimumCanCreatedValue,maximumCanCreatedValue);
            if (!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }
}
