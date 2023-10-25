package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private Integer minimumOfRange;
    private Integer maximumOfRange;
    private Integer numberOfNumbers;
    private Integer playOption;
    private Integer endOption;

    Scanner(Configurations configurations) {
        minimumOfRange = configurations.getMinimumOfRange();
        maximumOfRange = configurations.getMaximumOfRange();
        numberOfNumbers = configurations.getNumberOfNumbers();
        playOption = configurations.getPlayOption();
        endOption = configurations.getEndOption();
    }

    public List<Integer> inputUserNumber() {
        List<Integer> userNumbers = new ArrayList<>();
        String inStr = Console.readLine();

        for (char cur : inStr.toCharArray()) {
            userNumbers.add(cur - '0');
        }
        return userNumbers;
    }

    public Integer inputReplayOption() {
        Integer option = Integer.parseInt(Console.readLine());
        return option;
    }


}
