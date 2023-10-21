package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> playerNumbers;

    public Player(String input) {
        setNumbers(input);
    }

    public void setNumbers(String input) {
        this.playerNumbers = generateInputNumbers(input);
    }

    public List<Integer> getNumbers() {
        return playerNumbers;
    }

    public List<Integer> generateInputNumbers(String input) {
        int[] intArray = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new ArrayList<>(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
    }
}
