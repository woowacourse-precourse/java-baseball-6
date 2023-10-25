package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> input = new ArrayList<>();

    public User(int[] numbers) {
        input.clear();
        for(int i=0; i<numbers.length; i++){
            input.add(numbers[i]);
        }
    }

    public List<Integer> getInput() {
        return input;
    }

}
