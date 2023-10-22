package controller;

import java.util.List;

public class NumberChecker {

    private final List<Integer> randomNumbers;

    public NumberChecker(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public int getBall(int[] inputArr){
        int ball = 0;
        for(int i = 0; i < randomNumbers.size(); i++){
            ball += ballCheck(inputArr, i);
        }
        return ball;
    }

    private int ballCheck(int[] inputArr, int i) {
        if(randomNumbers.contains(inputArr[i]) && i != randomNumbers.indexOf(inputArr[i])){
            return 1;
        }
        return 0;
    }

    public int getStrike(int[] inputArr){
        int strike = 0;
        for(int i = 0; i < randomNumbers.size(); i++){
            strike += strikeCheck(inputArr, i);
        }
        return strike;
    }

    private int strikeCheck(int[] inputArr, int i) {
        if(randomNumbers.contains(inputArr[i]) && i == randomNumbers.indexOf(inputArr[i])){
            return 1;
        }
        return 0;
    }
}
