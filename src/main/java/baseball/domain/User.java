package baseball.domain;

import baseball.validator.BaseballValidator;

import java.util.List;

public class User extends BaseballValidator {
    List<Integer> baseball;
    public User(List<Integer> baseball){
        if(validator(baseball)){
            this.baseball=baseball;
        }
    }
}
