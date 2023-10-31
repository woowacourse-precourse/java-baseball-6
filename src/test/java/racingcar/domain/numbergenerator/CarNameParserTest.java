package racingcar.domain.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameParserTest {
    @Test
    void 이름_입력_파싱_테스트1() {
        String failInputNames = "dave";

        assertThatThrownBy(()->CarNameParser.parse(failInputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력_파싱_테스트2() {
        String failInputNames = "david,pobi";

        assertThatThrownBy(()->CarNameParser.parse(failInputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력_파싱_테스트3() {
        String successInputNames = "dave,pobi";
        List<CarName> names = new ArrayList<>();

        names.add(new CarName("dave"));
        names.add(new CarName("pobi"));

        assertThat(CarNameParser.parse(successInputNames)).isEqualTo(names);
    }
}
