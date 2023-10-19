package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGenerateTest {

    private static Number number;
    private static List<Integer> randomNumber;

    @BeforeAll
    static void beforeAll() {
        number = new Number();
        number.randomNumberGenerator();
        randomNumber = number.getNumber();
    }

    @Test
    void 생성된_랜덤_숫자가_3자리인지_테스트() {
        assertThat(randomNumber.size()).isSameAs(3);
    }

    @Test
    void 생성된_랜덤_숫자의_각_자리수가_다른지_테스트() {
        boolean flag = false;

        if(randomNumber.get(0) == randomNumber.get(1) ||
            randomNumber.get(1) == randomNumber.get(2) ||
            randomNumber.get(0) == randomNumber.get(2))
            flag = true;

        assertThat(flag).isFalse();
    }
}
