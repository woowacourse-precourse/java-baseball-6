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

        for (String num : input.split("")) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers;
    }


}
