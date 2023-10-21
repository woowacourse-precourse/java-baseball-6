package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.Application.userNumbers;

public class Validator {
    final String regex = "[0-9]+";
    public void check(String userInputNumber){
        if(userInputNumber.matches(regex) && checkSize(userInputNumber)){
            makeUserInputNumber(userInputNumber);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public boolean checkSize(String userInputNumber){
        return stoi(userInputNumber) >= 100 && stoi(userInputNumber) < 1000;
    }

    public void makeUserInputNumber(String userInputNumber) {
        String[] userInputNumbers = userInputNumber.split("");
        for (int i = 0; i < 3; i++) {
            userNumbers.add(stoi(userInputNumbers[i]));
        }
    }

    private Integer stoi(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }
}
