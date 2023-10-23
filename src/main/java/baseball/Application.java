package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> randomNumbers = GenerateAnswer.generate();
        System.out.println(randomNumbers);

    }
}
