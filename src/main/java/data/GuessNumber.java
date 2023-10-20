package data;

import camp.nextstep.edu.missionutils.Console;
import utility.BaseballNumberChecker;

import java.util.ArrayList;
import java.util.List;

public final class GuessNumber extends BaseballNumber{
    public GuessNumber() throws IllegalArgumentException{
        this.numbers = new ArrayList<>();
        this.input = Console.readLine();

        List<Integer> numbers = this.numbers;
        String input = this.input;

        BaseballNumberChecker.validateBaseballNumberSize(input);
        BaseballNumberChecker.validateBaseballNumberType(input);

        saveAsList(input);
        BaseballNumberChecker.isBaseballNumberSequence(numbers, MAX_NUMBER_LENGTH);
    }
    private void saveAsList(String input){
        List<Integer> numbers = this.numbers;
        String[] guessStrArr = input.split("");
        int currentNumber;
        for(int i = 0; i<MAX_NUMBER_LENGTH; i++){
            currentNumber = Integer.parseInt(guessStrArr[i]);
            numbers.add(currentNumber);
        }
    }
}
