package baseball;

import baseball.domain.NumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator generator = new NumberGenerator();
        List<Integer> numbers = generator.createRandomNumber();
        System.out.println(numbers);
    }
}
