package baseball;


import baseball.Controller.NumberController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberControllerTest {
    static final int NUMOFDIGIT = 3;

    @Test
    void 랜덤_수_길이_점검() {
        NumberController numberController = new NumberController();
        Integer[] result = numberController.createRandomNumber();
        assertThat(result).hasSize(NUMOFDIGIT);
    }
    @Test
    void 랜덤_수_중복_점검() {
        NumberController numberController = new NumberController();
        Integer[] result = numberController.createRandomNumber();
        assertThat(result).doesNotHaveDuplicates();
    }
    @Test
    void 유저_수_길이_점검_정상() {
        NumberController numberController = new NumberController();
        String validInput = "123";

        assertThatNoException().isThrownBy(() -> {
            numberController.checkLength(validInput);
        });
    }

    @Test
    void 유저_수_길이_점검_세자리_미만() {
        NumberController numberController = new NumberController();
        String invalidInput = "12";

        // 유효하지 않은 입력에 대해서 IllegalArgumentException이 발생해야 함
        assertThatThrownBy(() -> {
            numberController.checkLength(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("3자리 숫자를 입력해주세요. 프로그램을 종료합니다.");
    }

    @Test
    void 유저_수_길이_점검_세자리_이상() {
        NumberController numberController = new NumberController();
        String invalidInput = "1234";

        // 유효하지 않은 입력에 대해서 IllegalArgumentException이 발생해야 함
        assertThatThrownBy(() -> {
            numberController.checkLength(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("3자리 숫자를 입력해주세요. 프로그램을 종료합니다.");
    }
    @Test
    void 유저_수_변환_점검() {
        NumberController numberController = new NumberController();
        String userInput = "123";

        Integer[] result = numberController.getUserNumber(userInput);

        // 사용자 입력이 "123"일 때, 각 자릿수별로 올바른 숫자를 추출하는지 확인
        assertThat(result).containsExactly(1, 2, 3);
    }

}





