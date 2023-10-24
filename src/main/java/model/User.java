package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }
}
