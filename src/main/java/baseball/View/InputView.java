package baseball.View;


import baseball.Model.ViewValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String EVERY_CHARACTER = "";

    public List<Integer> receiveInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        String[] tokens = input.split(EVERY_CHARACTER);
        ViewValidator.validateInputValue(tokens);

        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1 / 종료하려면 2를 입력하세요 : ");
        String inputValue = Console.readLine();
        ViewValidator.validateRestartValue(inputValue);

        if ("1".equals(inputValue)) {
            return true;
        } else if ("2".equals(inputValue)) {
            return false;
        }
        System.out.println("잘못된 입력입니다. 다시 입력해주세요 : ");
        return restartGame();
    }
}