package baseball;

import baseball.domain.Judge;
import baseball.domain.JudgeNumber;
import baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumber();
//        System.out.println(numbers);

//        JudgeNumber judgeNumber = new JudgeNumber();
//        int count = judgeNumber.count(Arrays.asList(1,2,4), Arrays.asList(1,2,3));
//        System.out.println(count);
//        final boolean place = judgeNumber.isNumber(Arrays.asList(7,8,9), 0, 7);
//        System.out.println(place);

        Judge judge = new Judge();

        String result = judge.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        System.out.println(result);
    }
}
