package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
//기능별 분리를 안하니까 단위별 테스트가 어렵다!!!!!크악
    Validation validation = new Validation();

    @DisplayName("3개 이상의 글자가 들어왔을 경우 예외 발생 테스트")
    @Test
    void overSizeNumberTest() {
        assertThatThrownBy(() -> validation.validateThreeNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만 입력해주세요.");
    }

    @DisplayName("3개 미만의 글자가 들어왔을 경우 예외 발생 테스트")
    @Test
    void lessSizeNumberTest() {
        assertThatThrownBy(() -> validation.validateThreeNumbers("14"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만 입력해주세요.");
    }

    @DisplayName("중복된 수에 대한 테스트")
    @Test
    void duplicateNumberTest() {
        assertThatThrownBy(() -> validation.validateThreeNumbers("113"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 수는 입력할 수 없습니다");
    }

    @DisplayName("숫자 이외의 것이 들어왔을 때의 테스트")
    @Test
    void notOnlyNumberTest() {
        assertThatThrownBy(() -> validation.validateThreeNumbers("1a3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요");
    }


    @DisplayName("1 혹은 2가 아닐 경우 테스트")
    @Test
    void notCorrectSign() {
        assertThatThrownBy(() -> validation.validateSign("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시작은 1, 종료는 2 입니다.");
    }

    @DisplayName("1개의 숫자만 입력하지 않은 경우 테스트")
    @Test
    void notCorrectSizeSign() {
        assertThatThrownBy(() -> validation.validateSign("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 혹은 2만 입력해 주세요.");
    }
}