package baseball;

import java.util.ArrayList;

public class InputValidCheck {

    public void isReOrStopNum(String input) {
        if ( !input.equals("1") && !input.equals("2") ) {
            throw new IllegalArgumentException();
        }
    }
    public void isRepeat(String input) {

        ArrayList<Character> test = new ArrayList<>();
        char[] c = input.toCharArray();

        for(int i = 0; i < input.length(); i++ ) {

            if ( test.contains(c[i]) ) {
                throw new IllegalArgumentException();
            } else {
                test.add(c[i]);
            }
        }
    }
    public void isDigit(String input) {
        char[] c = input.toCharArray();

        for (char x : c ) {
            if ( !( x >= '1' && x <= '9') ) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isValidLength(String input) {

        if ( input.length() != 3 ) {
            throw new IllegalArgumentException();
        }
    }
}
