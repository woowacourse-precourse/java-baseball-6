package baseball;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Reader.readNumber;
import static baseball.Reader.readString;
import static java.util.Arrays.stream;


public class Player {
    private List<Integer> userNumberList;

    public Player() {
        this.userNumberList = null;
    }

    public List<Integer> load3NumberList() {
        userNumberList = generateListOf3Number();
        return userNumberList;
    }

    private List<Integer> generateListOf3Number() {
        String inputString = readString();
        List<Integer> userNumberList = changeStringToList(inputString);

        return userNumberList;
    }

    private List<Integer> changeStringToList(String inputString) {
        String[] strings = inputString.split("");

        return stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
