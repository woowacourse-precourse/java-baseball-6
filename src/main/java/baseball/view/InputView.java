package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String DELIMITER = "";
    private static final String REQUEST_PLAY_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> requestAnswerNumbers() {
        System.out.print(REQUEST_INPUT_NUMBERS);
        String answerNumbers = Console.readLine();
        return Arrays.stream(answerNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String requestPlayMoreGame() {
        System.out.println(REQUEST_PLAY_MORE_GAME);
        String playMoreGame = Console.readLine();
        return playMoreGame;
    }
}