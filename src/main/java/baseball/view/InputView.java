package baseball.view;

import baseball.domain.ReplayType;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REPLAY_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static List<Integer> convertUserInput(String input) {
        List<Integer> user = new ArrayList<>();
        String[] numbers = input.split("");
        for (String element : numbers) {
            int number = parseInt(element);
            user.add(number);
        }
        return user;
    }

    public List<Integer> readUserNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        return convertUserInput(input);
    }

    public boolean readShouldReplay() {
        System.out.println(REPLAY_INPUT_MESSAGE);
        String input = Console.readLine();
        ReplayType replayType = ReplayType.findTypeByInput(input);
        return replayType.isReplay();
    }

}
