package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> readPlayerNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBER_MESSAGE);
        return Arrays.stream(readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String readPlayerChoice() {
        System.out.println(INPUT_RETRY_MESSAGE);
        return readLine();
    }
}
