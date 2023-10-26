package racingcar.ui;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> inputCarNames() {
        String input = Console.readLine();

        List<String> nameList = List.of(input.split(","));
        for(String name: nameList) {
            if (name.length() >= 5) {
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }

    public static int inputAttempt() {
        String input = Console.readLine();
        int attempt;
        try {
            attempt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attempt < 1) {
            throw new IllegalArgumentException();
        }
        return attempt;
    }
}
