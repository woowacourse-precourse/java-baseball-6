//package baseball.controller;
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class BaseballControllerTest {
//    private final BaseballController baseballController = new BaseballController();
//
//    @Test
//    void 정답생성_세자리수() {
//        for (int i = 0; i <= 100; i++) {
//            int answer = baseballController.createAnswer();
//            assertThat(answer).isGreaterThan(99);
//            assertThat(answer).isLessThan(1000);
//        }
//    }
//
//    @Test
//    void 정답생성_중복숫자X() {
//        for (int i = 0; i <= 100; i++) {
//            int answer = baseballController.createAnswer();
//            int hundreds = answer / 100;
//            int tens = (answer / 10) % 10;
//            int ones = answer % 10;
//            assertThat(hundreds).isNotEqualTo(tens).isNotEqualTo(ones);
//            assertThat(tens).isNotEqualTo(ones);
//        }
//    }
//}