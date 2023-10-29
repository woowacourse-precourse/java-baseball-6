package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.*;

class CarTest {
    NumberGenerator successNumberGenerator = new SetNumberGenerator(4);
    NumberGenerator failureNumberGenerator = new SetNumberGenerator(3);

    @Test
    void 이름_검증_테스트1() {
        String name = "david";
        assertThatThrownBy(() -> new Car(name, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름_검증_테스트2() {
        String name = "";
        assertThatThrownBy(() -> new Car(name, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 자동차_이동_성공_테스트() {
        String name1 = "dave";
        String name2 = "paul";
        Car car1 = new Car(name1, successNumberGenerator);
        Car car2 = new Car(name2, successNumberGenerator);

        car1.tryMove();
        assertThat(car1.compareTo(car2) == 1).isTrue();
    }

    @Test
    void 자동차_이동_실패_테스트() {
        String name1 = "dave";
        String name2 = "paul";
        Car car1 = new Car(name1, failureNumberGenerator);
        Car car2 = new Car(name2, failureNumberGenerator);

        car1.tryMove();
        car1.tryMove();
        car2.tryMove();

        assertThat(car1.isSamePosition(car2)).isTrue();
    }

    @Test
    void 자동차_위치_동일_테스트() {
        String name1 = "dave";
        String name2 = "paul";
        Car car1 = new Car(name1, successNumberGenerator);
        Car car2 = new Car(name2, successNumberGenerator);

        car1.tryMove();
        car1.tryMove();
        car2.tryMove();
        car2.tryMove();

        assertThat(car1.isSamePosition(car2)).isTrue();
    }
}
