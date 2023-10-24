package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {

    private static final int COLLECT_USER_INPUT = 3;
    private static final int USER_START_NUMBER = 1;
    private static final int USER_END_NUMBER = 9;
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";

    private List<Integer>userNumber;

    public User(){
        userNumber = new ArrayList<>();
    }


    public List<Integer> readUserNumber(String userNumber) {
        updateStringToListUser(userNumber);
        validateUserNumber();
        return this.userNumber;
    }


    public List<Integer> updateStringToListUser(String userNumber){
        this.userNumber = new ArrayList<>();
        for(char c : userNumber.toCharArray())
            this.userNumber.add((c-'0'));
        return this.userNumber;
    }


    public void validateUserNumber() {
        validateIsThreeUserNumber();
        validateInRangeUserNumber();
        validateUniqueUserNumber();
    }

    public void validateIsThreeUserNumber() {
        if (userNumber.size() != COLLECT_USER_INPUT) throw new IllegalArgumentException();
    }

    public void validateInRangeUserNumber() {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) < USER_START_NUMBER || userNumber.get(i) > USER_END_NUMBER) throw new IllegalArgumentException();
        }
    }

    public void validateUniqueUserNumber() {
        userNumber.stream().distinct();
        if(userNumber.size() != userNumber.stream().distinct().count())
            throw new IllegalArgumentException();
    }

    public void validateRestartUserInput(String input) {
        if (!input.equals(RESTART_GAME) && !input.equals(END_GAME)) throw new IllegalArgumentException();
    }


}
