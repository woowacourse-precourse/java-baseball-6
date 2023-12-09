package baseball.Controller;

import java.util.ArrayList;

import static baseball.Constants.NUM_SIZE;

public class InputController {
    public static void checkException(final String str) {
        if(str.length() != NUM_SIZE){
            throw new IllegalArgumentException();
        }
        if(!checkInput(str)){
            throw new IllegalArgumentException();
        }
        if(!equalInput(str)){
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInput(String str){
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }

        ArrayList<Character> charArray = Array.getArrayFromStr(str);
        return !Array.checkArrayContains(charArray, '0');
    }

    static boolean equalInput(String str){
        ArrayList<Character> checkEqual = new ArrayList<>();
        ArrayList<Character> word = Array.getArrayFromStr(str);

        for(int i = 0; i < str.length(); i++) {
            if (Array.checkArrayContains(checkEqual, word.get(i))) {
                return false;
            }
            checkEqual.add(word.get(i));
        }
        return true;
    }
}
