package baseball.utils;

import java.util.Arrays;

public class Validator {
    public int[] validateInput(String input, int validSize)throws IllegalArgumentException {
        boolean[] isUnique = new boolean[10];
        Arrays.fill(isUnique,true);
        //Check size is valid size
        if (input.length() != validSize) {throw new IllegalArgumentException();}
        // parse to int
        int[] integerInput = new int[validSize];
        for(int i =0; i<validSize;i++){
            int digit = input.charAt(i) - '0';
            //check valid integer
            if (digit > 9 || digit < 0){throw new IllegalArgumentException();}
            //check is unique number
            if (!isUnique[integerInput[i]]){throw new IllegalArgumentException();}
            isUnique[digit] = false;
            integerInput[i] = digit;
        }
        return integerInput;
    }
}
