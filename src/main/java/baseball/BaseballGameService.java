package baseball;

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
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private void checkLength(String playerInput) {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자만 입력이 가능합니다.");
        }
    }

    private void checkRange(String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            int digit = Integer.parseInt(playerInput.split("")[i]);

            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException("1이상 9이하의 숫자로 이루어진 세 자리 숫자만 입력이 가능합니다.");
            }
        }
    }

    private void checkDuplicateNumber(String playerInput) {
        Set<Integer> inputNumSet = Stream.of(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toSet());

        if (inputNumSet.size() != 3) {
            throw new IllegalArgumentException("1부터 9까지의 서로 다른 수로 이루어진 세 자리 숫자만 입력이 가능합니다.");
        }
    }

    public Result umpire(Number computerNumber, Number playerNumber) {
        int strike = 0;
        int ball = 0;

        List<Integer> computerDigitList = computerNumber.getDigitList();
        List<Integer> playerDigitList = playerNumber.getDigitList();

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerDigitList.get(i), playerDigitList.get(i))) {
                strike++;
            } else if (computerDigitList.contains(playerDigitList.get(i))) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}
