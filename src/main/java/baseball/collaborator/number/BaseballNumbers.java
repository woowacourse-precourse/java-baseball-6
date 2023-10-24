package baseball.collaborator.number;

import baseball.collaborator.number.generator.NumbersGenerator;
import java.util.List;

// TODO : 현재까지는 '야구숫자'라는 이름을 가지고 사용해왔으나,  객체명을 좀 더 직관적으로 변경할 것
public class BaseballNumbers {

    private final List<Integer> baseballNumbers;

    public BaseballNumbers(NumbersGenerator numbersGenerator) {
        this.baseballNumbers = List.copyOf(numbersGenerator.generate());
    }

    public List<Integer> get() {
        return baseballNumbers;
    }

}
