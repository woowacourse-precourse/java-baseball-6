package baseball.domain;

import java.util.List;

public class User {

    private final List<Integer> userList;

    User(List<Integer> input){
        this.userList = input;
    }

    public List<Integer> getUserList() {
        return this.userList;
    }

}
