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
}
