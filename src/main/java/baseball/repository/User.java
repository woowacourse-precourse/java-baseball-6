package baseball.repository;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static User user;

    private List<Integer> userNumbers;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(String user) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < user.length(); i++) {
            temp.add(user.charAt(i) - '0');
        }
        this.userNumbers = temp;
    }
}
