package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;

public class Numbers {
    private final String numbers;

    public Numbers(String numbers){
        validateSize(numbers);
        validateType(numbers);
        validateUnique(numbers);

        this.numbers=numbers;
    }

    private void validateSize(String numbers){
        if (numbers.length()!=3){
            throw new IllegalArgumentException("값은 3자리 수여야 합니다.");
        }
    }

    private void validateType(String numbers){
        if (!numbers.matches("[0-9]+")){
            throw new IllegalArgumentException("값은 숫자로만 구성 되어야 합니다.");
        }
    }

    private void validateUnique(String numbers){
        if(new HashSet<>(Arrays.asList(numbers.split(""))).size()!=3){
            throw new IllegalArgumentException("값의 중복은 없어야 합니다.");
        }
    }

    public String getNumbers(){
        return numbers;
    }

}
