package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE ="숫자를 입력해주세요 :";
    private static final String DOT ="";
    private static final String GAME_RESTART_AND_SHUTDOWN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";

    public static List<Integer> inputNumber(){
        try {
            System.out.print(INPUT_NUMBER_MESSAGE);
            return Arrays.stream(Console.readLine().split(DOT))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static Integer retryGame() {
        try {
            System.out.println(GAME_RESTART_AND_SHUTDOWN_MESSAGE);
            return Integer.parseInt(Console.readLine());
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
