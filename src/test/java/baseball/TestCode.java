package baseball;

import org.junit.jupiter.api.Test;
public class TestCode {
    @Test
    void pickNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.generateRandomNum();
    }
}
