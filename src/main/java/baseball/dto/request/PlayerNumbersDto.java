package baseball.dto.request;

import java.util.List;

public class PlayerNumbersDto {

    private final List<Integer> numbers;

    public PlayerNumbersDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
