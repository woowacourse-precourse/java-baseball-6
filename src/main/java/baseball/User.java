package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> inputNumber;

    private static User user;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    public void setUserNumberFromConsole() {
        String st = Console.readLine();
        throwException(st);
        String[] arr = st.split("");
        inputNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputNumber.add(Integer.parseInt(arr[i]));
        }
    }

    private void throwException(String st) {
        String USER_NUM_REG_EX = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";
        if (!st.matches(USER_NUM_REG_EX)) {
            throw new IllegalArgumentException();
        }
    }

}
