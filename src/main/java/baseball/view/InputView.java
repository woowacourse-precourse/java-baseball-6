package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private static final String SEPARATOR = "";
    public List<Integer> inputGameNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        validateNumeric(numbers);
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }



    private void validateNumeric(String input){
        if(input.isBlank() || !NUMERIC_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }



}
