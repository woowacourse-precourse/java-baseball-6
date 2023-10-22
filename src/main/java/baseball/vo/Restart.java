package baseball.vo;

import baseball.model.RestartValidator;
import baseball.model.Validator;

public class Restart {
    private String option;

    public Restart(String input){
        Validator validator=new RestartValidator();
        validator.validate(input);

        this.option=input;
    }

    public boolean isContinue(){
        return option.equals("1");
    }

}
