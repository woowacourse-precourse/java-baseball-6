package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    List<Integer> userDigit = new ArrayList<>();
    int userNumber=0;

    public void stringValidation(String input) {
        if(!(Pattern.compile("[1-9]{3,3}").matcher(input).matches())) {
            throw new IllegalArgumentException("IllegalArgument for userNumber pattern");
        }
        if(input.length() != 3) {
            throw new IllegalArgumentException("IllegalArgument for userNumber length");
        }
    }

    public void setUserNumber(){
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        stringValidation(input);
        this.userNumber = Integer.parseInt(input);
        changeToList();
    }

    public void changeToList(){
        while(this.userNumber > 0) {
            userDigit.add(this.userNumber %10);
            this.userNumber /= 10;
        }
        Collections.reverse(this.userDigit);
    }
}
