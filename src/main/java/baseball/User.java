package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User extends ReadLine {

    private static User user;
    private List<Integer> inputNumber;

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
        guessNumberException(st);
        String[] arr = st.split("");
        inputNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputNumber.add(Integer.parseInt(arr[i]));
        }
    }
}
