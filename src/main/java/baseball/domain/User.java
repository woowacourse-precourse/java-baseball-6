package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumber;

    public User() {
        userNumber = new ArrayList<>();
    }

    public List<Integer> enterNum() {
        String input = Console.readLine();
        validLength(input);
        validType(input);
        validRange(input);
        validDuplication(input);
        insertNum(input);
        return userNumber;
    }

    private void validLength(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException("exceed length 3");
        }
    }

    private void validType(String input) {
        for (int i = 0; i < input.length(); i++) {
            int type = input.charAt(i) - '0';
            if(type < 0 || type > 10){
                throw new IllegalArgumentException("exist non-numeric type");
            }
        }
    }

    private void validRange(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("out of bounds range 1~9");
        }
    }

    private void validDuplication(String input) {
        String answer = removeDuplication(input);
        if(answer.length() != 3){
            throw new IllegalArgumentException("exist duplicated number");
        }
    }

    private String removeDuplication(String input) {
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            if(input.indexOf(input.charAt(i)) == i){
                answer += input.charAt(i);
            }
        }
        return answer;
    }

    private void insertNum(String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = Integer.valueOf(input.charAt(i)-'0');
            userNumber.add(num);
        }
    }

    public void reset() {
        userNumber.clear();
    }
    
}
