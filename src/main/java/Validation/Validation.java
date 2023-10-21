package Validation;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public void inputLengthIsZero(String input) {
        if(input.equals("")){
            throw new IllegalArgumentException();
        }
    }
    public void inputLengthIsOver(String input){
        if(input.length()>3){
            throw new IllegalArgumentException();
        }
    }
    public void inputLengthIsUnder(String input){
        if(input.length()<3){
            throw  new IllegalArgumentException();
        }
    }
    public void inputIsNotNumber(String input){
        for(int i=0; i<input.length();i++){
            int ascii = input.charAt(i);
            if(ascii<48 || ascii>51){
                throw new IllegalArgumentException();
            }
        }
    }
    public void duplicateNumber(String input){
        Set<Character> set = new HashSet<>();
        for(int i =0; i< input.length(); i++){
            set.add(input.charAt(i));
        }
        if(set.size()<3){
            throw new IllegalArgumentException();
        }
    }
}
