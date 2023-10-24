package baseball.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

    private List<Integer> numbers;

    private User(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> getInputNumbers(int numbers) {
        return Stream
                .of(String.valueOf(numbers).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static User readInputNumbers(String inputNumbers) {
        int userNumbers = Integer.parseInt(inputNumbers);
        List<Integer> readIntegerList = getInputNumbers(userNumbers);

        return new User(readIntegerList);
    }

    public List<Integer> getInputNumberList() {
        return numbers;
    }

}
