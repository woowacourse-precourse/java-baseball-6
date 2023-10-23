package baseball.service;

import static baseball.constant.Constant.MAX_NUMBER;
import static baseball.constant.Constant.MIN_NUMBER;
import static baseball.constant.Constant.NUMBER_LENGTH;
import static baseball.constant.ExceptionMessage.INPUT_DUPLICATE_EXCEPTION_MESSAGE;
import static baseball.constant.ExceptionMessage.INPUT_FORMAT_EXCEPTION_MESSAGE;
import static baseball.constant.ExceptionMessage.INPUT_LENGTH_EXCEPTION_MESSAGE;
import static baseball.constant.ExceptionMessage.INPUT_RANGE_EXCEPTION_MESSAGE;

import baseball.model.Computer;
import baseball.model.EndOption;
import baseball.model.Number;
import baseball.model.Player;
import baseball.model.Result;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGameService {
    public Number getComputerNumber() {
        return new Computer().getComputerNumber();
    }

    public Number getPlayerNumber(String playerInput) {
        validatePlayerNumberInput(playerInput);

        return new Player(playerInput).getPlayerNumber();
    }

    private void validatePlayerNumberInput(String playerInput) {
        isNumber(playerInput);
        checkLength(playerInput);
        checkRange(playerInput);
        checkDuplicateNumber(playerInput);
    }

    private void isNumber(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private void checkLength(String playerInput) {
        if (playerInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void checkRange(String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            int digit = Integer.parseInt(playerInput.split("")[i]);

            if (digit < MIN_NUMBER || digit > MAX_NUMBER) {
                throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private void checkDuplicateNumber(String playerInput) {
        Set<Integer> inputNumSet = Stream.of(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toSet());

        if (inputNumSet.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public Result umpire(Number computerNumber, Number playerNumber) {
        int strike = 0;
        int ball = 0;

        List<Integer> computerDigitList = computerNumber.getDigitList();
        List<Integer> playerDigitList = playerNumber.getDigitList();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (Objects.equals(computerDigitList.get(i), playerDigitList.get(i))) {
                strike++;
            } else if (computerDigitList.contains(playerDigitList.get(i))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }

    public Boolean playNextRound(String playerInput) {
        isNumber(playerInput);

        return switch (EndOption.findBySelection(playerInput)) {
            case NEXT_ROUND -> true;
            case END -> false;
        };
    }
}
