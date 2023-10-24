package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerRandomGameNumber {

    private String computerGameNumber;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MAX_NUMBER_LENGTH = 3;


    public ComputerRandomGameNumber(List<Integer> computerGameNumberList) {
        this.computerGameNumber = computerNumberListToString(computerGameNumberList);
    }

    public ComputerRandomGameNumber() {
        this.computerGameNumber = computerNumberListToString(getRandomsNumberList());
    }

    public String getComputerGameNumber() {
        return computerGameNumber;
    }

    public String computerNumberListToString(List<Integer> computerGameNumberList) {

        return computerGameNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static List<Integer> getRandomsNumberList() {
        List<Integer> computerGameNumbers = new ArrayList<>();
        while (computerGameNumbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computerGameNumbers.contains(randomNumber)) {
                computerGameNumbers.add(randomNumber);
            }
        }
        return computerGameNumbers;
    }
}