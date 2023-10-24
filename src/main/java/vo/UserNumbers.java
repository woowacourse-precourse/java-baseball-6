package vo;

import java.util.List;

public class UserNumbers {

    private List<Integer> userNumberList;

    public UserNumbers() {
    }

    public UserNumbers(List<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }
}
