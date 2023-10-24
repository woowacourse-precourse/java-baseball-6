package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Application.generateRandomAnswer;

public class MyTest{

    @Test
    void random(){
        List<Integer> answers = generateRandomAnswer();
        System.out.print("생성된 3자릿수: ");
        for (Integer answer : answers) {
            System.out.print(answer);
        }
        System.out.println();
        Assertions.assertThat(answers.size()).isEqualTo(3);
    }
}
