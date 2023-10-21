package baseball;

import java.util.ArrayList;
import java.util.Collections;

public class Computer {
    private static final int defaultDigitalCount = 3;
    private static final int minimumCanCreatedValue = 1;
    private static final int maximumCanCreatedValue = 9;
    private static final int modificationFactor = 1;
    private ArrayList<Integer> numberList;

    public Computer() {
        this.numberList = generateRandomNumberListWithNotRepeating();
    }
    public Computer(int digitCount){
        this.numberList = generateRandomNumberListWithNotRepeating(digitCount);
    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(){
        return generateRandomNumberListWithNotRepeating(defaultDigitalCount);
    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(int digitCount){

        var possibleNumberList = new ArrayList<Integer>();
        for (int i =minimumCanCreatedValue;i<=maximumCanCreatedValue;i+=modificationFactor){
            possibleNumberList.add(i);
        }

        Collections.shuffle(possibleNumberList);
        var randomNumberList = new ArrayList<Integer>();

        for (int i =0; i<digitCount;i++){
            randomNumberList.add(possibleNumberList.get(i));
        }
        return randomNumberList;
    }
}
