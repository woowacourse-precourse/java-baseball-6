package controller;

import java.util.List;

public class NumberChecker {

    private List<Integer> randomNumbers;

    public int getBall(List<Integer> inputList){
        int ball = 0;
        for(int i = 0; i < inputList.size(); i++){
            ball += ballCheck(inputList, i);
        }
        return ball;
    }

    private int ballCheck(List<Integer> inputList, int i) {
        if(randomNumbers.contains(inputList.get(i)) && i != randomNumbers.indexOf(inputList.get(i))){
            return 1;
        }
        return 0;
    }

    public int getStrike(List<Integer> inputList){
        int strike = 0;
        for(int i = 0; i < randomNumbers.size(); i++){
            strike += strikeCheck(inputList, i);
        }
        return strike;
    }

    private int strikeCheck(List<Integer> inputList, int i) {
        if(randomNumbers.contains(inputList.get(i)) && i == randomNumbers.indexOf(inputList.get(i))){
            return 1;
        }
        return 0;
    }

    public void setRandomNumbers(List<Integer> randomNumbers){
        System.out.println(randomNumbers.toString());
        this.randomNumbers = randomNumbers;
    }
    public void clear(){
        randomNumbers.clear();
    }
}
