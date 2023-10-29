package baseball.domain;

import baseball.view.Input;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private String userNumber;
    private int userNumberLength;


    public UserNumbers() {
        this.userNumber = Input.GetNumberInput();
        this.userNumberLength = this.userNumber.length();
        //System.out.println(userNumber); // del
    }

    public void ValidateNumbers() {

        // 3글자인지
        if(this.userNumberLength!=3) {
            throw new IllegalArgumentException("3글자 아님");
        }

        // 모두 숫자인지
        int i=0;
        for(i=0; i<this.userNumberLength; i++) {
            try {
                int num = Integer.parseInt(this.userNumber.substring(i, i+1));
            } catch (IllegalArgumentException e) {
            }
        }

        // 중복된 숫자가 없는지
        boolean[] seen = new boolean[10];
        for(char c : this.userNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                if (seen[num]) {
                    throw new IllegalArgumentException("숫자 중복");
                }
                seen[num]=true;
            }
        }
    }

    public String getUserNumber() {
        return userNumber;
    }

    public List<Integer> getUserNumberList() {
        List<Integer> list = new ArrayList<>();
        char[] numberStrings = userNumber.toCharArray();
        for (char numStr : numberStrings) {
            int number = Character.getNumericValue(numStr);
            list.add(number);
        }
        //System.out.println(list);
        return list;
    }
}
