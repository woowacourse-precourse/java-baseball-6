package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    private final InputValidator guessedNumberValidator;
    private final InputValidator continueModeNumberValidator;

    public InputReader() {
        this.guessedNumberValidator = new GuessedNumberValidator();
        this.continueModeNumberValidator = new ContinueModeNumberValidator();
    }

    // 유저가 추측한 값을 입력 받고 List 형태로 반환
    public List<Integer> readGuessedNumber() {
        String guessedNumberString = Console.readLine();
        guessedNumberValidator.validate(guessedNumberString);
        List<Integer> guessedNumber = Arrays.stream(guessedNumberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
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
