package racingcar.domain;

import racingcar.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.CAR_INIT_LOCATION;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar("Test");
    }

    @Test
    public void 자동차_이름_생성_테스트() {
        assertThat(racingCar.getName()).isEqualTo("Test");
        assertThat(racingCar.getLocation()).isEqualTo(CAR_INIT_LOCATION);
    }

    @Test
    public void 자동차_이름_예외_테스트() {
        assertThatThrownBy(() -> new RacingCar(""))
                .isInstanceOf(InvalidInputException.class);
        assertThatThrownBy(() -> new RacingCar("VeryLongCarName"))
                .isInstanceOf(InvalidInputException.class);
    }
}
