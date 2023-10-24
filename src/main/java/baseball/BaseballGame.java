package baseball;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BaseballGame {
    private final BaseballNumber numbers;

    public BaseballGame(int[] numbers) {
        this.numbers = new BaseballNumber(numbers);
    }


    public void sayHello(GameOutputInterface consoleLogger) {
        consoleLogger.print("숫자 야구 게임을 시작합니다.\n");
    }

    public void sayBi(GameOutputInterface consoleLogger) {
        consoleLogger.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public void run(GameInputInterface in, GameOutputInterface out) {
        while (true) {
            out.print("숫자를 입력해주세요 :");
            String input = in.getInput();
            checkInputs(input);
            BaseballNumber otherNumbers = BaseballNumber.ofString(input);
            out.print(numbers.getHintFrom(otherNumbers).toString());
            if (numbers.equals(otherNumbers)) {
                break;
            }
        }
        sayBi(out);
    }

    private static void checkInputs(String s) {
        if (Pattern.matches("[0-9]{3}", s)) {
            return;
        }
        throw new IllegalArgumentException("0~9까지 숫자 3자리수가 아닙니다.");
    }

}

