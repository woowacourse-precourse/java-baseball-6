package baseball.deprecated;

import java.util.List;

public class User {
    public List<Integer> getUserList() {
        return userList;
    }

    private final List<Integer> userList;

    public User(List<Integer> userList) {
        this.userList = userList;
    }
}
