package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputReader {
    public void readUserInput(){
        String input = Console.readLine();


    }

    public void validateInputSize(String input){
        if(input.length() != 3) throw new IllegalArgumentException("input's size have to be 3");
    }

    public void validateInputType(String input){
        if(!input.matches("[0-9]+")) throw new IllegalArgumentException("input have to type only number.");
    }

    public void validateInputDuplicationOfNumber(String input){
        Set<Character> set = new HashSet<>();

        for(char c : input.toCharArray()){
            set.add(c);
        }

        if(set.size() != input.length()) throw new IllegalArgumentException("input can't be typed duplicated number.");
    }
}
