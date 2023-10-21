package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumber;

    public User() {
        userNumber = new ArrayList<>();
    }

    public void enterNum() {
        String input = Console.readLine();
        int num = validType(input);
        validRange(num);
        validDuplication(num);
    }

    public int validType(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("exist non-numeric type");
        }

        return Integer.parseInt(input);
    }

    public void validRange(int input) { // test에서 String으로 넣음. 내가 했던 처음 방법
        if(input < 1 || input > 10){
            throw new IllegalArgumentException("out of bounds range 1~9");
        }
    }

    public void validDuplication(int input) {
        if(userNumber.contains(input)){
            throw new IllegalArgumentException("exist duplicated number");
        }
    }

    public void reset() {
        userNumber.clear();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

}
