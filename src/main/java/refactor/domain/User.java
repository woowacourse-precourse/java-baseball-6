package refactor.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> number;

    public User() {};

    public void userNumberGenerator(String inputNumber) {
        List<Integer> userNumber = new ArrayList<>();
        for(Character c : inputNumber.toCharArray())
            userNumber.add(c - '0');

        this.number = userNumber;
    }

    public List<Integer> getNumber() {
        return this.number;
    }
}
