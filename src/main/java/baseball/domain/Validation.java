package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;

public class Validation {
    public boolean gameValue(String input){
        String regex="[0-9]+";
        HashSet<String> uniqueInput=new HashSet<>(Arrays.asList(input.split("")));

        return input.length()==3 && input.matches(regex) && uniqueInput.size()==3;
    }
}
