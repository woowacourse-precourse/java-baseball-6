package baseball.domain;

import java.util.ArrayList;

public class UserNumbers {
    private static final int SIZE = 3;
    public ArrayList<Integer> userNumber;
    public UserNumbers(ArrayList<Integer> userNumber) {
        sizeValid(userNumber);
        duplicateValid(userNumber);
        this.userNumber = userNumber;
    }
    private void sizeValid(ArrayList<Integer> userNumber) {
        if (userNumber == null || userNumber.size() != SIZE) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        }
    }
    private void duplicateValid(ArrayList<Integer> userNumber){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < i; j++) {
                if (userNumber.get(i).equals(userNumber.get(j))) {
                    throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요");
                }
            }
        }
    }
}
