package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputReader {

    private final InputValidator guessedNumberValidator;
    private final InputValidator continueModeNumberValidator;

    public InputReader(InputValidator guessedNumberValidator, InputValidator continueModeNumberValidator) {
        this.guessedNumberValidator = guessedNumberValidator;
        this.continueModeNumberValidator = continueModeNumberValidator;
    }

    // 유저가 추측한 값을 입력 받고 List 형태로 반환
    public List<Integer> readGuessedNumber() {
        String guessedNumberString = Console.readLine();
        guessedNumberValidator.validate(guessedNumberString);
        List<Integer> guessedNumber = TypeConverter.stringToIntegerList(guessedNumberString);
        return guessedNumber;
    }

    // 게임 Continue 여부를 입력받고 반환
    public Integer readContinueModeNumber() {
        String continueModeNumberString = Console.readLine();
        continueModeNumberValidator.validate(continueModeNumberString);
        int continueModeNumber = Integer.parseInt(continueModeNumberString);
        return continueModeNumber;
    }
}
