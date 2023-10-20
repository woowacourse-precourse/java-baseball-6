package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> user = new ArrayList<>();

    public User(String number){
        checkInteger(number);
        checkDuplicateNumber(number);
        checkLength(number);
        generateUser(number);
    }

    public List<Integer> getUser() {
        return user;
    }

    private void checkLength(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("길이가 3이 아닙니다.");
        }
    }

    private void checkDuplicateNumber(String number) {
        for (String stringNumber : number.split("")) {
            int intNumber = Integer.parseInt(stringNumber);
            if (user.contains(intNumber)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }

    private void checkInteger(String number) {
        for (String stringNumber : number.split("")) {
            try {
                int intNumber = Integer.parseInt(stringNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    private void generateUser(String number) {
        for (String stringNumber : number.split("")) {
            int intNumber = Integer.parseInt(stringNumber);
            user.add(intNumber);
        }
    }
}
