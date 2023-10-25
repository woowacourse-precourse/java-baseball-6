package baseball.domain.player.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record PlayerNumbersDto(String playerNumbers) {

    public PlayerNumbersDto {
        Objects.requireNonNull(playerNumbers, "input cannot be null");
        if (playerNumbers.equals("")) throw new IllegalArgumentException("숫자 3자리로 입력하세요");
        validateInputNumbers(playerNumbers);
    }

    public static PlayerNumbersDto of(String playerNumbers) {
        return new PlayerNumbersDto(playerNumbers);
    }

    public void validateInputNumbers(String number) {
        List<String> inputNumbers = Arrays.stream(number.split("")).toList();
        validateInputNumbersSize(inputNumbers);
        validateInputIsNumbers(inputNumbers);
    }

    private void validateInputNumbersSize(List<String> inputNumbers) {
        if(inputNumbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 서로 다른 세자리 수 입력");
        }
    }

    private void validateInputIsNumbers(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
