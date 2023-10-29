package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.SetNumberGenerator;

class CarsTest {
    NumberGenerator successNumberGenerator = new SetNumberGenerator(4);
    NumberGenerator failureNumberGenerator = new SetNumberGenerator(3);
    @Test
    void 이름_잘못된_입력_테스트() {
        String inputNames = "dave,paul,";

        assertThatThrownBy(() -> {
            new Cars(inputNames, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름_입력_5글자_테스트() {
        String inputNames = "david";

        assertThatThrownBy(() -> {
            new Cars(inputNames, successNumberGenerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름_입력_성공_테스트() {
        String inputNames = "a,b,c";
        Cars cars = new Cars(inputNames, successNumberGenerator);
        List<Car> carList = ;

        IntStream.rangeClosed(0,2).forEach(i -> assertThat(
                cars.getCars()
                        .get(i)
                        .getName())
                .isEqualTo(inputNames.split(",")[i]));
    }

    @Test
    void 자동차_이동_성공_테스트() {
        String inputNames = "a,b,c,d";
        Cars cars = new Cars(inputNames, successNumberGenerator);
        cars.allTryMove();

        cars.getCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }

    @Test
    void 자동차_이동_실패_테스트() {
        String inputNames = "a,b,c,d";
        Cars cars = new Cars(inputNames, failureNumberGenerator);
        cars.allTryMove();

        cars.getCars().forEach(car -> {
            assertThat(car.getPosition()).isEqualTo(0);
        });
    }


    @Test
    void 불변_컬렉션_테스트() {
        String inputNames = "a,b,c,d";
        Cars cars = new Cars(inputNames, successNumberGenerator);
        List<Car> cars1 = cars.getCars();

        Car newCar = new Car("f", successNumberGenerator);

        assertThatThrownBy(() -> cars1.add(newCar)).isInstanceOf(UnsupportedOperationException.class);

    }
}
