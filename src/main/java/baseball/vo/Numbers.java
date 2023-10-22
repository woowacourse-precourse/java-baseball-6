package baseball.vo;

import baseball.model.NumbersValidator;
import baseball.model.Validator;

public class Numbers {
    private final String numbers;

    public Numbers(String numbers){
        Validator validator=new NumbersValidator();
        validator.validate(numbers);

        this.numbers=numbers;
    }

    public String[] splitNumbers(){
        return numbers.split("");
    }

    public int index(String number){
        return numbers.indexOf(number);
    }
}
