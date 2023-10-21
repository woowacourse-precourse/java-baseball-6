package baseball.controller;

import baseball.domain.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DataControllerTest {

    private DataController dataController = new DataController() {
        @Override
        public List<String> readValues() {
            return List.of("1", "2", "3");
        }
    };

    @DisplayName("사용자의 3가지 숫자를 생성한다.")
    @Test
    void generatePlayerNumbers() {
        List<Balls> actual = dataController.generatePlayerNumbers();

        List<Balls> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Balls(i + 1, i));
        }

        Assertions.assertAll(
                () -> Assertions.assertEquals(balls, actual)
        );
    }
}
