package baseball.controller;

import baseball.domain.Computer;
import baseball.dto.JudgeDTO;
import baseball.service.GameService;

import java.util.Arrays;

public class GameController {

    private static final String OUT_OF_BOUND = "입력된 숫자가 범위를 벗어났습니다.";
    private static final String NON_NUMERIC_EXCEPTION = "숫자만 입력해주세요.";
    private static final String DUPLICATED_ELEMENT_EXCEPTION = "중복된 값을 입력할 수 없습니다.";
    private static final int PROCESS_CAPACITY = 3;
    private static final int RETRY_CAPACITY = 1;
    private static final int RETRY = 1;
    private static final int EXIT = 2;

    private final Computer computer;
    private final GameService gameService;

    private static GameController INSTANCE;
    private GameController(Computer computer, GameService gameService) {
        this.computer = computer;
        this.gameService = gameService;
    }
    public static GameController getInstance(Computer computer, GameService gameService) {
        if (INSTANCE == null)
            INSTANCE = new GameController(computer, gameService);
        return INSTANCE;
    }

    public void start() {
        computer.generateBaseball();
    }

    public JudgeDTO process(String input) {
        validateCapacity(input, PROCESS_CAPACITY);
        char[] charArray = validateNumericOnly(input);
        validateDuplication(charArray.clone());

        int[] numbers = changeIntArray(charArray);

        return gameService.process(computer.numbersOfBaseballs(), numbers);
    }

    public boolean isRetry(String input) {
        validateCapacity(input, RETRY_CAPACITY);
        validateNumericOnly(input);

        int status = Integer.parseInt(input);

        if (status == RETRY) return true;
        if (status == EXIT) return false;

        throw new IllegalArgumentException(OUT_OF_BOUND);
    }

    private void validateDuplication(char[] charArray) {
        Arrays.sort(charArray);

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1])
                throw new IllegalArgumentException(DUPLICATED_ELEMENT_EXCEPTION);
        }
    }

    private char[] validateNumericOnly(String input) {
        char[] charArray = input.toCharArray();

        for (char ch : charArray) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION);
        }

        return charArray;
    }

    private void validateCapacity(String input ,int capacity) {
        if (input.length() != capacity)
            throw new IllegalArgumentException(OUT_OF_BOUND);
    }

    private int[] changeIntArray(char[] charArray) {
        int[] numbers = new int[PROCESS_CAPACITY];

        for (int i = 0; i < charArray.length; i++) {
            numbers[i] = Character.getNumericValue(charArray[i]);
        }

        return numbers;
    }

}
