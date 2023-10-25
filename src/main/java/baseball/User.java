package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> number = new ArrayList<>();

    public User(String input) {
        for (String splitInput : input.split("")) {
            number.add(Integer.parseInt(splitInput));
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
