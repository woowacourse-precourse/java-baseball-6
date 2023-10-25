package baseball.util;

import org.junit.jupiter.api.Test;

public class Parser {
    public int[] parserUserInput(String input, int size) throws IllegalArgumentException{
        if(input.length() != size) throw new IllegalArgumentException();
        String[] numList = input.split("");
        int[] parseInt = new int[size];
        for(int i = 0; i < input.length(); i++){
            if(Integer.valueOf(numList[i]) == null){
                throw new IllegalArgumentException();
            }
            parseInt[i] = Integer.valueOf(numList[i]);
        }
        return parseInt;
    }
}
