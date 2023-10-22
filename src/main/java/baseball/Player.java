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
    private boolean isDuplicatedNumber(final List<Integer> randomNumberList, final int number) {
        return randomNumberList.contains(number);
    }

    public boolean chooseFinishGame() {
        int input = readNumber();

        if (input != 1 && input != 2) throw new IllegalArgumentException("1 또는 2를 입력해주세요.");

        return input == 2;
    }
}
