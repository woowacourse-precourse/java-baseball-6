package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.RandomNumberGenerator;

class CarNameTest {
    @Test
    void 이름_입력_5글자_테스트() {
        String inputNames = "david";

        assertThatThrownBy(() -> {
            List<CarName> carNameList = Arrays.stream(inputNames.split(","))
                    .map(CarName::new)
                    .toList();

            new Cars(carNameList, new RandomNumberGenerator());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력_공백_테스트() {
        String inputNames = "";

        assertThatThrownBy(() -> {
            List<CarName> carNameList = Arrays.stream(inputNames.split(","))
                    .map(CarName::new)
                    .toList();

            new Cars(carNameList, new RandomNumberGenerator());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
