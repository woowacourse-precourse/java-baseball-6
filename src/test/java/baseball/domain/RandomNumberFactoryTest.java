package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberFactoryTest {

    @Test
    void generate_메서드는_새로운_BaseballNumber_객체를_생성한다() {
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory();
        assertThat(randomNumberFactory.generate()).isInstanceOf(BaseballNumber.class);
    }
}
