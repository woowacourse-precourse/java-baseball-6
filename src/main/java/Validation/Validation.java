package Validation;

import java.util.HashSet;
import java.util.Set;

import static baseball.Application.NUMBER_LENGTH;

public class Validation {
    public void inputLengthIsZero(String input) {
        if(input.equals("")){
            throw new IllegalArgumentException();
        }
    }
    public void inputLengthIsOver(String input){
        if(input.length()>NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }
    }
    public void inputLengthIsUnder(String input){
        if(input.length()<NUMBER_LENGTH){
            throw  new IllegalArgumentException();
        }
    }
    public void inputIsNotNumber(String input){
        for(int i=0; i<input.length();i++){
            int ascii = input.charAt(i);
            if(ascii<48 || ascii>58){
                throw new IllegalArgumentException();
            }
        }
    }
    public void duplicateNumber(String input){
        Set<Character> set = new HashSet<>();
        for(int i =0; i< input.length(); i++){
            set.add(input.charAt(i));
        }
        if(set.size()<NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }
    }
    public void userGameStartValidation(String input){
        inputLengthIsZero(input);
        inputIsNotNumber(input);
        inputLengthIsOver(input);
        inputLengthIsUnder(input);
        duplicateNumber(input);
    }
    public void userGameRestartOrEndValidation(String input){
        inputLengthIsZero(input);
        inputIsNotNumber(input);
    }
}
