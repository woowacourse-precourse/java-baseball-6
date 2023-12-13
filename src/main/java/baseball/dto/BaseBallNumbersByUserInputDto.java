package baseball.dto;

import baseball.model.Numbers;
import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbersByUserInputDto {
    private final String input;

    public BaseBallNumbersByUserInputDto(String input) {
        this.input = input;
    }

    public Numbers toNumbers() {
        return new Numbers(convertNumbersByInput());
    }

    private List<Integer> convertNumbersByInput() {
        List<Integer> numbers = new ArrayList<>();
        String[] splitInputNumbers = input.split("");

        for (String num : splitInputNumbers) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers;
    }


}
