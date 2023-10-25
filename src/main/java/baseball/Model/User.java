package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> input;

    public User(List<Integer> numbers) {
        input = numbers;
    }

    public List<Integer> getInput() {
        return input;
    }

}
