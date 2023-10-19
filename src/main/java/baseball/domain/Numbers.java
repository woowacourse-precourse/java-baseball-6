package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;

public class Numbers {
    private final String numbers;

    public Numbers(String numbers){
        if(!validate(numbers)){
            throw new IllegalArgumentException();
        }
        this.numbers=numbers;
    }

    private boolean validate(String numbers){
        return isCorrectSize(numbers) && isConsistofNumbers(numbers)
                && isNotDuplicate(numbers);
    }

    private boolean isCorrectSize(String numbers){
        return numbers.length()==3;
    }

    private boolean isConsistofNumbers(String numbers){
        return numbers.matches("[0-9]+");
    }

    private boolean isNotDuplicate(String numbers){
        HashSet<String> uniqueNumbers=new HashSet<>(Arrays.asList(numbers.split("")));

        return uniqueNumbers.size()==3;
    }

    public String getNumbers(){
        return numbers;
    }

}
